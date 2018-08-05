package com.jnshu.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@Component
@MapperScan("com.jnshu.dao")
public class MybatisConfiguration {

}
