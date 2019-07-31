package com.sys.controller;

import com.sys.common.response.ResultResponse;
import com.sys.domain.SysUser;
import com.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peter
 * @version 1.1
 * @date 2019/7/18 11:19
 */
@RestController
@Slf4j
@Api(description = "DEMO"  )
public class SysUserController {
    @Autowired
    private SysUserService userService;

    @ApiOperation(value = "更新密码" )
    @PutMapping("/user/edit")
    public ResultResponse updateUser(String password,Integer userId){
        SysUser user = new SysUser();
        user.setPassword(password);
        user.setUserId(userId);
        return userService.updatePassword(user);
    }
}
