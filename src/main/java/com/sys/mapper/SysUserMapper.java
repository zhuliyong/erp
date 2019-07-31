package com.sys.mapper;

import com.sys.domain.SysUser;
import org.springframework.stereotype.Repository;

/**
 * @author peter
 * @version 1.1
 * @date 2019/7/18 10:35
 */
@Repository
public interface SysUserMapper {

    int update (SysUser user);
}
