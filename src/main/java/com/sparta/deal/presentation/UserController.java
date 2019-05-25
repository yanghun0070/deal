package com.sparta.deal.presentation;

import com.sparta.deal.domain.UserInfo;
import com.sparta.deal.presentation.vo.UserVo;
import com.sparta.deal.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 로그인 접속
     * @return 로그인
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() throws Exception {
        return "user/login";
    }

    /**
     * 회원 가입 페이지
     * @return 회원 가입
     */
    @RequestMapping(value = "join", method = RequestMethod.GET)
    public String join() throws Exception {
        return "user/join";
    }

    /**
     * 회원 생성
     * @return 회원 생성
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@RequestParam UserVo userVo) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        UserInfo user = modelMapper.map(userVo, UserInfo.class);
        userService.create(user);
        return "user/login";
    }
}
