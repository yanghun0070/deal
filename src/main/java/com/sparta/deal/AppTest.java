package com.sparta.deal;

import com.sparta.deal.domain.UserInfo;
import com.sparta.deal.infra.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class AppTest implements CommandLineRunner {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("test");
        userInfo.setPassword("test");
        userInfo.setAge(99);
        userInfo.setEmail("yanghun007@naver.com");
        userInfo.setSex(0);//0:M, 1:W
        userJpaRepository.save(userInfo);
    }

    public static void main(String []args) throws Exception {
        SpringApplication.run(AppTest.class, args);
    }
}
