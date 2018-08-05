package com.jnshu.controller;

import com.jnshu.entity.Product;
import com.jnshu.dto1.ProductListRPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品模块相关接口
 * @author wangqichao
 */
@RestController
public class ProductController {
    private static final Logger log= LoggerFactory.getLogger(ProductController.class);

    /**
     * 获得产品列表
     * @param rpo 查询条件
     * @return 返回参数，包括code,message,total,size,产品列表
     */
    @GetMapping(value = "/a/u/product/list")
    public Map getProductList(@ModelAttribute ProductListRPO rpo){
        log.info("获得产品列表，查询条件为"+rpo);
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        map.put("total",10086);
        map.put("size",rpo.getSize());
        List<Product> productList=new ArrayList<>();
        for (int i=0;i<rpo.getSize();i++){
            Product product=new Product();
            product.setId(i*3+1000);
            product.setProductCode("ZXC");
            product.setProductName("万箭齐发");
            product.setInterestRate("0.18");
            product.setDeadline(180);
            product.setRateOfInterest(2);
            product.setStatus(0);
            product.setIsRecommend(1);
            productList.add(product);
        }
        map.put("data",productList);
        return map;
    }

    /**
     * 按照产品id获得指定产品详情
     * @param id 产品id
     * @return 返回参数，code,message,产品详情
     */
    @GetMapping(value = "/a/u/product/{id}")
    public Map getProduct(@PathVariable(value = "id")long id){
        log.info("获得自定产品详情，产品id为"+id);
        Map<String,Object> map=new HashMap<>();
        map.put("code",id);
        map.put("message","ok");
        Product product=new Product();
        product.setId(1000);
        product.setProductCode("ZXC");
        product.setProductName("万箭齐发");
        product.setInterestRate("0.18");
        product.setDeadline(180);
        product.setInvestmentAmount("50000");
        product.setRateOfInterest(2);
        product.setRefundStyle(0);
        product.setMark(1);
        product.setRemark("这个是新产品，安排一下");
        product.setIsRecommend(1);
        product.setIsLimitePurchase(0);
        product.setMoreMessage("https://jnshuphoto.oss-cn-hangzhou.aliyuncs.com/headphoto/823.png");
        map.put("data",product);
        return map;
    }

    /**
     * 修改指定产品
     * @param id 产品id
     * @param product 修改产品的内容
     * @return 修改结果，code,message
     */
    @PutMapping(value = "/a/u/product/{id}")
    public Map updateProduct(@PathVariable(value = "id")long id,@ModelAttribute Product product){
        log.info("修改，产品id为"+id+"修改为"+product);
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        return map;
    }

    /**
     * 新增产品信息
     * @param product 新增产品的详情
     * @return 返回参数，code,message
     */
    @PostMapping(value = "/a/u/product")
    public Map addProduct(@ModelAttribute Product product){
        log.info("新增产品，产品详情为"+product);
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        return map;
    }

    /**
     * 修改产品状态
     * @param id 产品id
     * @param status 希望成为的状态
     * @return 修改结果，code,message
     */
    @PutMapping(value = "/a/u/product/{id}/status")
    public Map updateProductStatus(@PathVariable (value = "id")long id,@RequestParam(value = "status")int status){
        log.info("修改产品状态为"+status);
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        return map;
    }



}
