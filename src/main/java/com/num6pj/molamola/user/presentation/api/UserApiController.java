package com.num6pj.molamola.user.presentation.api;

import com.num6pj.molamola.user.application.UserService;
import com.num6pj.molamola.user.domain.UserInfo;
import com.num6pj.molamola.user.presentation.vo.UserVo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserApiController {

    @Autowired
    private UserService userService;

    /**
     * 회원 가입
     */
    @RequestMapping(value = "join", method = RequestMethod.POST)
    public void join(@RequestBody UserVo userVo) throws Exception {
        UserInfo user = new ModelMapper().map(userVo, UserInfo.class);
        userService.join(user);
    }


}


