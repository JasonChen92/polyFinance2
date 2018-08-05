package com.jnshu.controller;

import com.jnshu.dto1.ProductListRPO;
import com.jnshu.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品管理相关模块
 * @author wangqichao
 */
@RestController
public class ProductController {

    private static final Logger log= LoggerFactory.getLogger(ProductController.class);

    /**
     * 获得产品列表
     * @param rpo 是否是推荐产品，区别推荐页
     * @return 返回参数，code,message，产品列表
     */
    @GetMapping(value = "/a/product/list")
    public Map getProductList(ProductListRPO rpo){
        log.info("获得产品列表，1代表推荐页，没有代表全部，条件为："+rpo.getIsRecommend());
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        List<Product> productList=new ArrayList<>();
        for(int i=0;i<20;i++){
            Product product=new Product();
            product.setId(i*3+1000);
            product.setProductName("万箭齐发");
            product.setInterestRate("0.18");
            product.setDeadline(180);
            product.setInvestmentAmount("50000");
            product.setMark(1);
            productList.add(product);
        }
        map.put("data",productList);
        return map;
    }

    /**
     * 获得指定产品详情
     * @param id 产品id
     * @return 返回参数，code,message,产品详情
     */
    @GetMapping(value = "/a/u/product/{id}")
    public Map getProduct(@PathVariable(value = "id")long id){
        log.info("获得id为"+id+"的产品");
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        Product product=new Product();
        product.setId(id);
        product.setProductName("万箭齐发");
        product.setInterestRate("0.18");
        product.setDeadline(180);
        product.setInvestmentAmount("50000");
        product.setMark(1);
        product.setRateOfInterest(1);
        product.setRefundStyle(1);
        product.setMoreMessage("https://jnshuphoto.oss-cn-hangzhou.aliyuncs.com/headphoto/843.png");
        map.put("data",product);
        return map;
    }
}
