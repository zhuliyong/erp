package com.sys.service;

import com.sys.common.response.ResultResponse;
import com.sys.domain.SysUser;

/**
 * @author peter
 * @version 1.1
 * @date 2019/7/18 11:11
 */
public interface SysUserService {

     ResultResponse updatePassword(SysUser user);

}
