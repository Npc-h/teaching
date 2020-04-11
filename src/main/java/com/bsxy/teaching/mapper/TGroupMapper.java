package com.bsxy.teaching.mapper;

import com.bsxy.teaching.pojo.TGroup;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TGroupMapper {


    int deleteByPrimaryKey(Integer gId);

    int insert(TGroup record);

    int insertSelective(TGroup record);


    TGroup selectByPrimaryKey(Integer gId);



    int updateByPrimaryKeySelective(TGroup record);

    int updateByPrimaryKey(TGroup record);
}