package com.jnshu.controller;

import com.jnshu.dto1.StatisticsSalesListRO;
import com.jnshu.dto1.StatisticsSalesListRPO;
import com.jnshu.entity.StatisticsSalesRO;
import com.jnshu.dto1.StatisticsSalesRPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统计模块，销量统计使用相关接口
 * @author wangqichao
 */
@RestController
public class StatisticsController {
    private static final Logger log= LoggerFactory.getLogger(StatisticsController.class);

    /**965
     * 获得销量统计列表
     * @param rpo 查询条件
     * @return 返回参数，code,message,产品销量统计
     */
    @GetMapping(value = "/a/u/statistics/sales/list")
    public Map getStatisticsSalesList(@ModelAttribute StatisticsSalesListRPO rpo){
    log.info("获得销量统计列表");
    Map<String,Object> map=new HashMap<>();
    map.put("code",10000);
    map.put("message","ok");
    map.put("total",rpo.getSize()*3);
    map.put("size",rpo.getSize());
    List<StatisticsSalesListRO> ros=new ArrayList<>();
    for(int i=0;i<rpo.getSize();i++) {
        StatisticsSalesListRO ro = new StatisticsSalesListRO();
        ro.setId(i);
        ro.setProductCode("ZXC"+i);
        ro.setProductName("满汉全席"+i);
        ro.setPeopleCounting(i*100+1000);
        ro.setNumberOfTimes(i*150+1500);
        ro.setTotalMoney("500000"+5000*i);
        ros.add(ro);
    }
    map.put("data",ros);
    return map;
}

@GetMapping(value = "/a/u/statistics/sales/{id}")
    public Map getStatisticsSales(@PathVariable(value = "id")long id, @ModelAttribute StatisticsSalesRPO rpo){
        rpo.setId(id);
        log.info("按条件"+rpo+"查询产品销量");
    Map<String,Object> map=new HashMap<>();
    map.put("code",10000);
    map.put("message","ok");
    map.put("total",rpo.getSize()*3);
    map.put("size",rpo.getSize());
    List<StatisticsSalesRO> ros=new ArrayList<>();
    for(int i=0;i<rpo.getSize();i++) {
        StatisticsSalesRO ro=new StatisticsSalesRO();
        ro.setProductName("满汉全席"+i);
        ro.setDate(System.currentTimeMillis()+i*24*3600*1000);
        ro.setPeopleCounting(i*10+100);
        ro.setNumberOfTimes(i*15+150);
        ro.setTotalMoney("50000"+5000*i);
        ros.add(ro);
    }
    map.put("data",ros);
    return map;
}

}
