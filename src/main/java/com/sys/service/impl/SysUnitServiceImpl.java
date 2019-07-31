package com.sys.service.impl;

import com.sys.common.response.ResultResponse;
import com.sys.common.response.ResultServer;
import com.sys.domain.SysUnit;
import com.sys.mapper.SysUnitMapper;
import com.sys.service.SysUnitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author peter
 * @version 1.1
 * @date 2019/7/31 16:43
 */
@Service
@Slf4j
@Transactional(readOnly = true,rollbackFor = Exception.class )
public class SysUnitServiceImpl implements SysUnitService {

    @Autowired
    SysUnitMapper unitDao;

    //添加计量单位
    @Override
    @Transactional
    public ResultResponse addUnit(SysUnit pd) {
        Integer res =unitDao.insert(pd);
        if(res!=null && res.intValue()==1){
            return ResultServer.succes("添加成功");
        }
        log.error("==添加计量单位失败");
        return ResultServer.error("添加失败");
    }

    //删除计量单位
    @Override
    @Transactional
    public ResultResponse deleteUnit(Integer unitId) {
        Integer res =unitDao.deleteByPrimaryKey(unitId);
        if(res!=null && res.intValue()==1){
            return ResultServer.succes("删除成功");
        }
        log.error("==添加计量单位失败");
        return ResultServer.error("删除失败");
    }
}
