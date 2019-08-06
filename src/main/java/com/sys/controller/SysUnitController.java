package com.sys.controller;

import com.sys.common.response.ResultResponse;
import com.sys.domain.SysUnit;
import com.sys.service.SysUnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peter
 * @version 1.1
 * @date 2019/7/31 16:52
 */

@RestController
@Slf4j
@Api(description = "计量单位"  )
public class SysUnitController {

    @Autowired
    SysUnitService unitService;

    @ApiOperation(value = "添加/编辑计量单位")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "unitCode", value = "计量单位编码", required = true),
            @ApiImplicitParam(name = "unitName", value = "计量单位名称", required = true),
            @ApiImplicitParam(name = "unitId", value = "计量单位ID", required = false)
    })
    @PostMapping("/unit/new")
    public ResultResponse addUnit(String unitCode,String unitName,String unitId){
        SysUnit pd = new SysUnit();
        pd.setUnitCode(unitCode);
        pd.setUnitName(unitName);
        if(unitId == null || "".equals(unitId)){
            return unitService.addUnit(pd);
        }else{
            pd.setUnitId(Integer.valueOf(unitId));
            return unitService.editUnit(pd);
        }

    }



    @ApiOperation(value="删除计量单位")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "unitId",value = "主键ID",required = true)
    })
    @PostMapping("/unit/del")
    public ResultResponse moveUnit(Integer unitId){
        return unitService.deleteUnit(unitId);
    }


    @ApiOperation(value = "计量单位分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo",value = "当前页码",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页行数",required = true)
    })
    @PostMapping("unit/page")
    public ResultResponse listPage(Integer pageNo,Integer pageSize){
        return unitService.listPage(pageNo,pageSize);
    }

}
