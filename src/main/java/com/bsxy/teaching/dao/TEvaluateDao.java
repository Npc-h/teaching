package com.bsxy.teaching.dao;

import com.bsxy.teaching.mapper.TEvaluateMapper;
import com.bsxy.teaching.pojo.TCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName TEvaluateDao
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/10
 * @Version V1.0
 **/
@Repository
public class TEvaluateDao {
    @Autowired
    private TEvaluateMapper tEvaluateMapper;

    public List<TCourse> selectEvaluation(int curr, int limits, String evaluationName, String personName) {
        return tEvaluateMapper.selectEvaluation(curr,limits,evaluationName,personName);
    }

    public Integer selectEvaluationCount(String evaluationName, String personName) {
        return tEvaluateMapper.selectEvaluationCount(evaluationName,personName);
    }
}
