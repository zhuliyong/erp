package com.sys.service;

import com.sys.common.response.ResultResponse;
import com.sys.domain.SysUnit;

/**
 * @author peter
 * @version 1.1
 * @date 2019/7/31 16:34
 */
public interface SysUnitService {

    ResultResponse addUnit(SysUnit pd);

    ResultResponse deleteUnit(Integer unitId);
}
