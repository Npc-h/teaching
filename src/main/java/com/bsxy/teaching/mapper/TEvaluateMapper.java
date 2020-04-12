package com.bsxy.teaching.mapper;

import com.bsxy.teaching.pojo.TCourse;
import com.bsxy.teaching.pojo.TEvaluate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TEvaluateMapper {


    int deleteByPrimaryKey(Integer eId);

    int insert(TEvaluate record);

    int insertSelective(TEvaluate record);


    TEvaluate selectByPrimaryKey(Integer eId);



    int updateByPrimaryKeySelective(TEvaluate record);

    int updateByPrimaryKey(TEvaluate record);

    List<TCourse> selectEvaluation(@Param("curr") Integer curr, @Param("limits") Integer limits,@Param("evaluationName") String evaluationName,@Param("personName") String personName);

    Integer selectEvaluationCount(@Param("evaluationName") String evaluationName,@Param("personName") String personName);
}