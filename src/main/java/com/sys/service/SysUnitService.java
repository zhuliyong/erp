package com.sys.service;

import com.sys.common.response.ResultResponse;
import com.sys.domain.SysUnit;

/**
 * @author peter
 * @version 1.1
 * @date 2019/7/31 16:34
 */
public interface SysUnitService {

    /**
     * 添加
     * @param pd
     * @return
     */
    ResultResponse addUnit(SysUnit pd);

    /**
     * 编辑
     * @param pd
     * @return
     */
    ResultResponse editUnit(SysUnit pd);

    /**
     * 删除
     * @param unitId
     * @return
     */
    ResultResponse deleteUnit(Integer unitId);

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    ResultResponse listPage(Integer pageNo,Integer pageSize);
}
