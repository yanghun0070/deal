package com.num6pj.molamola.security.config;

import com.num6pj.molamola.manager.application.SiteService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Web 보안 설정
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private SiteService siteService;

    private Logger logger;

    @Bean
    public UrlResourceMapFactoryBean urlResourceMapFactoryBean() {
        return new UrlResourceMapFactoryBean();
    }

    /**
     * authenticationManager를 사용하기 위해, Bean 객체 설정
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AccessDecisionManager accessDecisionManager() {
        return new DefaultAccessDecisionManager();
    }

    @Bean
    public JwtTokenFilter authenticationTokenFilterBean() {
        return new JwtTokenFilter(jwtTokenProvider);
    }

    /**
     * Http Security 설정
     * @param httpSecurity http security
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
//        .httpBasic().disable()
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .anyRequest()
        .authenticated()
        .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            public <O extends FilterSecurityInterceptor> O postProcess(O fsi) {
                fsi.setSecurityMetadataSource(
                        new DefaultFilterInvocationMetadataSource(siteService.findRoleResources()));
                fsi.setAccessDecisionManager(accessDecisionManager());
//                fsi.setPublishAuthorizationSuccess(true);
                return fsi;
            }
        })
        .and()
        .headers()
        .frameOptions().disable()
        .and()
        .apply(new JwtConfigurer(jwtTokenProvider));

        httpSecurity
                .addFilterBefore(authenticationTokenFilterBean(),
                        UsernamePasswordAuthenticationFilter.class);

    }


    /**
     * prefix 비밀번호 암호 알고리즘, 알고리즘에 의해 변화된 hash 값을 추가할 수 있다.
     * {<encryption>}<your-password-hash>.
     * @todo 추후, 암호화 알고리즘으로 변경한다. 현재는 알고리즘 사용안했을 시, {noop}password 를 사용한다.
     * @return Password Encoder
     */
    @Bean
    public NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}
