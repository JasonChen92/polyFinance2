package com.jnshu.dao;

import com.jnshu.Entry;
import com.jnshu.entity.TimedTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//classes后面是启动类.class
@SpringBootTest(classes = Entry.class)
public class TimedTaskMapperTest {
@Autowired
TimedTaskMapper timedTaskMapper;
    @Test
    public void deleteOldTransReturn() {
        System.out.println(timedTaskMapper.deleteOldTransReturn(100));
    }

    @Test
    public void addTaskedTime() {
        TimedTask timedTask=new TimedTask();
        timedTask.setCreateAt(System.currentTimeMillis());
        timedTask.setCreateBy(1);
        timedTask.setStatus(0);
        timedTask.setTaskTime(System.currentTimeMillis()+10*3600*1000);
        timedTask.setNature(1);
        timedTask.setMoney("5000");
        timedTask.setTransactionId(100);
        timedTask.setClaimsId(1);
        timedTaskMapper.addTaskedTime(timedTask);
        System.out.println(timedTask.getId());
    }

    @Test
    public void getOldTaskTimeByClaimsId() {
        System.out.println(timedTaskMapper.getOldTaskTimeByClaimsId(1));
    }

    @Test
    public void updateTaskTimeByClaimsId() {
        TimedTask timedTask=new TimedTask();
        timedTask.setUpdateAt(System.currentTimeMillis());
        timedTask.setUpdateBy(1);
        timedTask.setClaimsId(1);
        timedTask.setTaskTime(System.currentTimeMillis()+10*3600*1000);
        System.out.println(timedTaskMapper.updateTaskTimeByClaimsId(timedTask));
    }
}