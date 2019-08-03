package com.sys.mapper;

import com.sys.domain.PageData;
import com.sys.domain.SysUnit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUnitMapper {
    int deleteByPrimaryKey(Integer unitId);

    int insert(SysUnit record);

    int insertSelective(SysUnit record);

    SysUnit selectByPrimaryKey(Integer unitId);

    int updateByPrimaryKeySelective(SysUnit record);

    int updateByPrimaryKey(SysUnit record);

    List<PageData> findList();
}