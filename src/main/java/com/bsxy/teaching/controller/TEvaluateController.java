package com.bsxy.teaching.controller;

import com.bsxy.teaching.pojo.TCourse;
import com.bsxy.teaching.pojo.TEvaluate;
import com.bsxy.teaching.service.TEvaluateService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    //插入评教
    @RequestMapping(value = "/insertEvaluate")
    @ResponseBody
    public Integer insertEvaluate(HttpServletRequest request){
        //读取参数

        int  survey = Integer.parseInt(request.getParameter("survey"));
        int  survey_1 = Integer.parseInt(request.getParameter("survey_1"));
        int  survey_2 = Integer.parseInt(request.getParameter("survey_2"));
        int surveys = survey+survey_1+survey_2;

        TEvaluate tEvaluate =new TEvaluate();
        tEvaluate.setEContent(request.getParameter("bodyDesc"));
        tEvaluate.setECourse(request.getParameter("cNames"));
        tEvaluate.setETeacher(request.getParameter("cTeachers"));
        tEvaluate.setEPerson(request.getParameter("cPersons"));
        tEvaluate.setEGrade(surveys+"");

        String lID = request.getParameter("LId");


      return tEvaluateService.insertEvaluate(tEvaluate,lID);

    }
}
