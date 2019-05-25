package com.sparta.deal.presentation.api;

import com.sparta.deal.domain.UserInfo;
import com.sparta.deal.presentation.vo.UserVo;
import com.sparta.deal.service.UserService;
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
     * @return
     */
    @RequestMapping(value = "join", method = RequestMethod.POST)
    public void create(@RequestBody UserVo userVo) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        UserInfo user = modelMapper.map(userVo, UserInfo.class);
        userService.create(user);
    }




}


