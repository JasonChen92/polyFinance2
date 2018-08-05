package com.jnshu.service1;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jnshu.dao.ClaimsMapper;
import com.jnshu.dto1.ClaimsListRPO;
import com.jnshu.entity.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 债权相关service
 * @author wangqichao
 */
@Service
public class ClaimsService {
    @Autowired
    ClaimsMapper claimsMapper;

    private static final Logger log= LoggerFactory.getLogger(ClaimsService.class);

    public Page<Claims> getClaimsList(ClaimsListRPO rpo){

        Page<Claims> claimsPage= PageHelper.startPage(rpo.getPage(),rpo.getSize());
        claimsMapper.getClaimsListByRpo(rpo);
        System.out.println(claimsPage.getResult());
        return claimsPage;
    }
}
