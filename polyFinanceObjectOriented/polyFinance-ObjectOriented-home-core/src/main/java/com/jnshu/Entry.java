package com.jnshu;

import com.jnshu.dao.ProductMapper;
import com.jnshu.entity.Product;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
@MapperScan({"com.jnshu.dao","com.jnshu.dao2","com.jnshu.dao3"})
public class Entry {
    public static void main(String[] args) {
        SpringApplication.run(Entry.class,args);
    }
}
