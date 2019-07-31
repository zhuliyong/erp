package com.sys.service.impl;

import com.sys.common.response.ResultResponse;
import com.sys.common.response.ResultServer;
import com.sys.common.tools.MD5Util;
import com.sys.domain.SysUser;
import com.sys.mapper.SysUserMapper;
import com.sys.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Results;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author peter
 * @version 1.1
 * @date 2019/7/18 11:13
 */
@Service
@Slf4j
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper userDao;

    @Override
    @Transactional
    public ResultResponse updatePassword(SysUser user) {
        String password = user.getPassword();
        password = MD5Util.md5EncodeUtf8(password);
        user.setPassword(password);
        Integer res =  userDao.update(user);
        if(res !=null && res.intValue()==1){
            return ResultServer.succes("修改成功");
        }
        return ResultServer.error("修改失败");
    }
}
