package com.bsxy.teaching.service;

import com.bsxy.teaching.dao.TEvaluateDao;
import com.bsxy.teaching.dao.TListenDao;
import com.bsxy.teaching.pojo.TCourse;
import com.bsxy.teaching.pojo.TEvaluate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName TEvaluateService
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/10
 * @Version V1.0
 **/
@Service
public class TEvaluateService {
    @Autowired
    private TEvaluateDao tEvaluateDao;

    @Autowired
    private TListenDao tListenDao;

    public List<TCourse> selectEvaluation(String page, String limit, String evaluationName, String personName) {
        int curr = Integer.parseInt(page);
        int limits = Integer.parseInt(limit);
        curr = (curr-1)*limits;
        return tEvaluateDao.selectEvaluation(curr,limits,evaluationName,personName);
    }

    public Integer selectEvaluationCount(String evaluationName, String personName) {
        return tEvaluateDao.selectEvaluationCount(evaluationName,personName);
    }

    @Transactional
    public Integer insertEvaluate(TEvaluate tEvaluate, String lID) {
        //查如评价表
        tEvaluateDao.insertEvaluate(tEvaluate);
        //更新听课表
        return tListenDao.updateEvaluate(lID);
    }
}
