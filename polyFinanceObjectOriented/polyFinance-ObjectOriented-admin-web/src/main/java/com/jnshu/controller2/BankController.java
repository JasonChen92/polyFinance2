package com.jnshu.controller2;

import com.jnshu.Domain2.DomainBank;
import com.jnshu.dto2.BankListRPO;
import com.jnshu.model.bankandbandcard.Bank;
import com.jnshu.model.bankandbandcard.BankInfo;
import com.jnshu.service.BankService;
import com.jnshu.utils.CAM;
import com.jnshu.utils.TokenUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BankController {
    private static Logger logger = Logger.getLogger(BankController.class);

    private static TokenUtil tokenUtil = new TokenUtil();

    @Autowired
    BankService bankService;

    //银行列表
    @RequestMapping(value = "/a/u/banks",method = RequestMethod.GET)
    public List<Object> getBanks(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                 @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                 @ModelAttribute BankListRPO rpo,
                                 HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> account = new HashMap<>();
        CAM cam = new CAM();
        account = tokenUtil.getAccount(request);

        //返回数据List。
        List<Object> result = new ArrayList<>();

        //参数校验。
        //编辑时间同时存在。
        if (null != rpo.getUpdateAt1() || null != rpo.getUpdateAt2()){
            if (null == rpo.getUpdateAt1() || null == rpo.getUpdateAt2()){
                cam.setCode(-1);
                cam.setMessage("两个编辑时间必须同时存在");
                result.add(cam);
                return result;
            }
        }

        //单笔限额同时存在。
        if(null != rpo.getSingleLimited1() || null != rpo.getSingleLimited2()){
            if (null == rpo.getSingleLimited1() || null == rpo.getSingleLimited2()){
                cam.setCode(-1);
                cam.setMessage("两个单笔限额必须同时存在");
                result.add(cam);
                return result;
            }
        }

        //日累计限额同时存在。
        if (null != rpo.getDayLimited1() || null != rpo.getDayLimited2()){
            if (null == rpo.getDayLimited1() || null ==rpo.getDayLimited2()){
                cam.setCode(-1);
                cam.setMessage("两个单日限额必须同时存在");
                result.add(cam);
                return result;
            }
        }
        //查询银行列表。
        List<DomainBank> banks = null;
        try {
            banks = bankService.getBankList(pageNum,pageSize,rpo);
            if (0 == banks.size()){
                cam.setCode(-1);
                cam.setErrorMessage("当前条件没有符合记录。");
                result.add(cam);
                return result;
            }
            cam.setMessage("总数与查询条件无关。");
        } catch (Exception e) {
            CAM cam1 = new CAM(-1,"服务器错误。");
            cam1.setErrorMessage("服务器在获取银行列表时出错");
            e.printStackTrace();
            logger.info("后台 运营管理--银行列表。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+rpo);
            result.add(cam1);
            return result;
        }

        //查询银行总数。
        Integer total = null;
        try {
            total = bankService.getTotal();
        } catch (Exception e) {
            CAM cam1 = new CAM(-1,"服务器错误。");
            cam1.setErrorMessage("服务器在获取银行列表总数时出错");
            e.printStackTrace();
            logger.info("后台 运营管理--银行列表--总数成功。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+rpo);
            result.add(cam1);
            return result;
        }

        Map<String, Object> s = new HashMap<>();
        s.put("pageNum", pageNum);
        s.put("pageSize", pageSize);
        s.put("total", total);
        result.add(s);
        result.add(cam);
        result.add(banks);
        logger.info("后台 运营管理--银行列表出错。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+rpo);
        return result;
    }

    //银行详情
    @RequestMapping(value = "/a/u/banks/{id}",method = RequestMethod.GET)
    public List<Object> getBnkInfo(@PathVariable long id, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> account = new HashMap<>();
        CAM cam = new CAM();
        account = tokenUtil.getAccount(request);

        //返回数据List。
        List<Object> result = new ArrayList<>();

        //参数校验。
        if (id <1){
            cam.setCode(-1);
            cam.setMessage("id错误。");
            result.add(cam);
            return result;
        }

        //业务
        com.jnshu.entity.Bank bank = new com.jnshu.entity.Bank();
        try {
            bank = bankService.getBankById(id);
            if (bank == null){
                cam.setCode(-1);
                cam.setMessage("此id无对应记录。");
                result.add(cam);
                return result;
            }
        } catch (Exception e) {
            CAM cam1 = new CAM(-1,"服务器错误。");
            cam1.setErrorMessage("服务器在获取银行详情总数时出错");
            e.printStackTrace();
            logger.info("后台 运营管理--银行详情出错。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求id参数： "+id);
            result.add(cam1);
            return result;
        }

        cam.setMessage("获取银行详情成功。");
        result.add(cam);
        result.add(bank);
        logger.info("后台 运营管理--银行详情成功。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求id参数： "+id);
        return result;
    }

    //银行信息更新
    @RequestMapping(value = "/a/u/banks/{id}",method = RequestMethod.PUT)
    public List<Object> updateBnkInfo(@PathVariable long id,
                                      @ModelAttribute com.jnshu.entity.Bank bank,
                                      HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> account = new HashMap<>();
        CAM cam = new CAM();
        account = tokenUtil.getAccount(request);

        //返回数据List。
        List<Object> result = new ArrayList<>();

        //参数校验
        if (null == bank.getDayLimited() || null == bank.getSingleLimited() || null == bank.getPaymentId() || null == bank.getWithdrawalId() ) {
            CAM cam1 = new CAM(-1,"单笔限额,日累计限额,支付机构号,提现机构号不能为空值。");
            result.add(cam1);
            return result;
        }

        if (("").equals(bank.getDayLimited())|| ("").equals(bank.getSingleLimited())|| ("").equals(bank.getPaymentId())|| ("").equals(bank.getWithdrawalId())){
            CAM cam1 = new CAM(-1,"单笔限额,日累计限额,支付机构号,提现机构号不能没有值。");
            result.add(cam1);
            return result;
        }
        if (Double.valueOf(bank.getDayLimited()) < 0 || Double.valueOf(bank.getSingleLimited())<0){
            CAM cam1 = new CAM(-1,"单笔限额或日累计限额不能小于0");
            result.add(cam1);
            return result;
        }

        bank.setId(id);
        bank.setUpdateAt(System.currentTimeMillis());
        bank.setUpdateBy((Long) account.get("uid"));
        Boolean up = false;
        try {
            up = bankService.updateBank(bank);
            if (!up){
                cam.setCode(-1);
                cam.setMessage("此id无对应记录。");
                result.add(cam);
                return result;
            }
        } catch (Exception e) {
            CAM cam1 = new CAM(-1,"服务器错误。");
            cam1.setErrorMessage("服务器在更新银行详情时出错");
            e.printStackTrace();
            logger.info("后台 运营管理--更新银行详情出错。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+bank);
            result.add(cam1);
            return result;
        }

        cam.setMessage("银行记录更新成功。");
        result.add(cam);
        logger.info("后台 运营管理--更新银行详情成功。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+bank);
        return result;
    }

    //银行信息新增
    @RequestMapping(value = "/a/u/banks/new",method = RequestMethod.POST)
    public List<Object> saveBnkInfo(@ModelAttribute com.jnshu.entity.Bank bank, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> account = new HashMap<>();
        CAM cam = new CAM();
        account = tokenUtil.getAccount(request);

        //返回数据List。
        List<Object> result = new ArrayList<>();

        //参数校验
        if (null == bank.getDayLimited() || null == bank.getSingleLimited() || null == bank.getPaymentId() || null == bank.getWithdrawalId() ) {
            CAM cam1 = new CAM(-1,"单笔限额,日累计限额,支付机构号,提现机构号不能为空值。");
            result.add(cam1);
            return result;
        }

        if (Double.valueOf(bank.getDayLimited()) < 0 || Double.valueOf(bank.getSingleLimited())<0){
            CAM cam1 = new CAM(-1,"单笔限额或日累计限额不能小于0");
            result.add(cam1);
            return result;
        }

        //先查
        Long existId = null;
        try {
            existId = bankService.getBankIdByBankName(bank.getBankName());
            if (null != existId){
                CAM cam1 = new CAM(-1,"已经存在相同记录。");
                result.add(cam1);
                return result;
            }
        } catch (Exception e) {
            CAM cam1 = new CAM(-1,"服务器错误。");
            cam1.setErrorMessage("服务器在新增银行时查询是否存在已有记录出错");
            e.printStackTrace();
            logger.info("后台 运营管理--新增银行记录时查询是否存在已有记录出错。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+bank);
            result.add(cam1);
            return result;
        }

        //新增
        Long id = null;
        bank.setCreateAt(System.currentTimeMillis());
        bank.setCreateBy((Long) account.get("uid"));
        bank.setUpdateAt(System.currentTimeMillis());
        bank.setUpdateBy((Long) account.get("uid"));
        try {
            id = bankService.saveBank(bank);
            if (id == null){
                cam.setCode(-1);
                cam.setMessage("新增银行记录失败。");
                result.add(cam);
                return result;
            }
        } catch (Exception e) {
            CAM cam1 = new CAM(-1,"服务器错误。");
            cam1.setErrorMessage("服务器在新增银行记录时出错");
            e.printStackTrace();
            logger.info("后台 运营管理--新增银行记录出错。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+bank);
            result.add(cam1);
            return result;
        }

        cam.setMessage("新增记录成功。");
        result.add(cam);
        logger.info("后台 运营管理--新增银行记录成功。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+bank);
        return result;
    }
}
