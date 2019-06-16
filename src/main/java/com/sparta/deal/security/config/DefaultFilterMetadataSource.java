package com.sparta.deal.security.config;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;

/**
 * URL 이 권한과 일치하는 지 확
 */
public class DefaultFilterMetadataSource implements FilterInvocationSecurityMetadataSource {

//    private  Map<RequestMatcher, Collection<ConfigAttribute>> requestMap;


    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation filterInvocation = (FilterInvocation) object;
        String url = filterInvocation.getRequestUrl();
        /**
         * @todo 매번 DB 에서 꺼내올 필요 없으므로,redis 및 Cache 를 통해 저장한다.
         */

        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
