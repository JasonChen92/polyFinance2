package com.jnshu.controller2;

import com.jnshu.model.feedback.Feedback;
import com.jnshu.utils.CAM;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OtherController {
    private CAM cam = new CAM();

    //参数设置-参数获取
    @RequestMapping(value = "/a/u/datas",method = RequestMethod.GET)
    public List<Object> getDatas() {
        List<Object> result = new ArrayList<>();
        Map<String,Object> data = new HashMap<>();
        data.put("officialSeal", "www.dslj");
        data.put("inverstmentDay", 5);
        data.put("creditorDay", 5);
        data.put("creditorLine", 0.8);
        result.add(cam);
        result.add(data);
        return result;
    }

    //参数设置-参数保存
    @RequestMapping(value = "/a/u/datas",method = RequestMethod.PUT)
    public List<Object> saveDatas(
            @RequestParam(required = false) String officialSeal
            ,@RequestParam(required = false) String investmentDay,
            @RequestParam(required = false) String creditorDay,
            @RequestParam(required = false) String creditorLine) {
        List<Object> result = new ArrayList<>();
        Map<String,Object> data = new HashMap<>();
        data.put("officialSeal", officialSeal);
        data.put("inverstmentDay", investmentDay);
        data.put("creditorDay", creditorDay);
        data.put("creditorLine", creditorLine);
        result.add(cam);
        result.add("参数保存 接收到的数据："+data);
        return result;
    }

    //参数设置-参数保存
    @RequestMapping(value = "/a/u/datas",method = RequestMethod.POST)
    public List<Object> returnDatas() {
        List<Object> result = new ArrayList<>();
        result.add(cam);
        return result;
    }

    //版本管理-获取
    @RequestMapping(value = "/a/u/versions",method = RequestMethod.GET)
    public List<Object> getVersion(){
        List<Object> result = new ArrayList<>();
        Map<String,String> version = new HashMap<>();
        version.put("versionName", "1.0.1");
        version.put("version", "1");
        version.put("url", "wwww.baidu.com");
        version.put("versionInfo", "更新了后台管理");
        result.add(cam);
        result.add(version);
        return result;
    }

    //版本管理-更新
    @RequestMapping(value = "/a/u/versions",method = RequestMethod.PUT)
    public List<Object> saveVersion(
            @RequestParam(required = false) String versionName,
            @RequestParam(required = false) String version,
            @RequestParam(required = false) String url,
            @RequestParam(required = false) String versionInfo){
        List<Object> result = new ArrayList<>();
        Map<String,String> versions = new HashMap<>();
        versions.put("versionName", versionName);
        versions.put("version",version );
        versions.put("url", url);
        versions.put("versionInfo",versionInfo );
        result.add(cam);
        result.add(versions);
        return result;
    }

    //意见反馈-意见列表
    @RequestMapping(value = "/a/u/feedbacks",method = RequestMethod.GET)
    public List<Object> getFeedbacks(
            @RequestParam(required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(required = false,defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String realName,
            @RequestParam(required = false) Long createAt1,
            @RequestParam(required = false) Long createAt2,
            @RequestParam(required = false) String email) {
        List<Object> result = new ArrayList<>();
        List<Feedback> list = new ArrayList<>();

        for (int i=1;i<pageSize;i++){
            Feedback feedback = new Feedback();
            feedback.setId((long) i);
            feedback.setPhoneNumber("123425");
            feedback.setRealName("张立");
            feedback.setEmail("1112342@qq.com");
            feedback.setCreateAt(System.currentTimeMillis());
            list.add(feedback);
        }
        result.add(cam);
        result.add(list);
        return result;
    }

    //意见反馈-意见详情
    @RequestMapping(value = "/a/u/feedbacks/{id}",method = RequestMethod.GET)
    public List<Object> getFeedback(@PathVariable long id) {
        List<Object> result = new ArrayList<>();

        Map<String,Object> feedbackInfo = new HashMap<>();
        feedbackInfo.put("id", id);
        feedbackInfo.put("phoneNumber", "3423554");
        feedbackInfo.put("realName", "王三");
        feedbackInfo.put("email", "53242@163.com");
        feedbackInfo.put("createAt", System.currentTimeMillis());
        result.add(cam);
        result.add(feedbackInfo);
        return result;
    }

    //意见反馈-意见详情
    @RequestMapping(value = "/a/u/feedbacks/{id}",method = RequestMethod.DELETE)
    public List<Object> deleteFeedback(@PathVariable long id) {
        List<Object> result = new ArrayList<>();

        result.add(cam);
        return result;
    }
}
