package com.bsxy.teaching.mapper;

import com.bsxy.teaching.pojo.TStudent;
import java.util.List;

import com.bsxy.teaching.pojo.TTeacher;
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

    List<TTeacher> selectStudent(@Param("curr") Integer curr, @Param("limits") Integer limits,@Param("studentName") String studentName);

    Integer selectStudentCount(@Param("studentName") String studentName);
}