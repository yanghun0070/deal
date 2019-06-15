package com.sparta.deal.user.presentation.api;

import com.sparta.deal.manager.application.AuthorizationService;
import com.sparta.deal.user.domain.UserInfo;
import com.sparta.deal.user.application.UserService;
import com.sparta.deal.user.presentation.vo.UserVo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserApiController {

    @Autowired
    private UserService userService;


    /**
     * 회원 가입
     */
    @RequestMapping(value = "join", method = RequestMethod.POST)
    public void create(@RequestBody UserVo userVo) throws Exception {
        UserInfo user = new ModelMapper().map(userVo, UserInfo.class);
        userService.create(user);
    }


}


