package com.bsxy.teaching.controller;

import com.bsxy.teaching.pojo.TCourse;
import com.bsxy.teaching.service.TEvaluateService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TEvaluateController
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/10
 * @Version V1.0
 **/
@Controller
public class TEvaluateController {
    @Autowired
    private TEvaluateService tEvaluateService;

    //查询评教
    @RequestMapping(value = "/selectEvaluation")
    @ResponseBody
    public Map<String, Object> selectEvaluation(String page, String limit, String evaluationName,String personName){
        List<TCourse> tFoods = tEvaluateService.selectEvaluation(page, limit,evaluationName,personName);
        JSONArray array = JSONArray.fromObject(tFoods);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", tEvaluateService.selectEvaluationCount(evaluationName,personName));
        result.put("data", array);
        return result;
    }
}
