package com.bsxy.teaching.mapper;

import com.bsxy.teaching.pojo.TStudent;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TStudentMapper {


    int deleteByPrimaryKey(Integer sId);

    int insert(TStudent record);

    int insertSelective(TStudent record);


    TStudent selectByPrimaryKey(Integer sId);



    int updateByPrimaryKeySelective(TStudent record);

    int updateByPrimaryKey(TStudent record);
}