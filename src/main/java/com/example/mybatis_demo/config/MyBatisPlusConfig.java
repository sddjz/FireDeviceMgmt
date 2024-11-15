package com.example.mybatis_demo.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
//import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@MapperScan("com.example.mybatis_demo.mapper")
@EnableTransactionManagement//自动管理事务；可用于乐观锁
@Configuration
public class MyBatisPlusConfig {


    /**
    @Bean
    @Profile({"dev","test"})//set dev test env on->keep the effiency
    public PerformanceInterceptor performanceINtercepter(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //不想让用户等待
        performanceInterceptor.setMaxTime(200);//sql执行最大时间100ms,如果超过则不执行
        performanceInterceptor.setFormat(true);//格式化sql
        return performanceInterceptor;
    }

    */
    //乐观锁
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
            return new OptimisticLockerInterceptor();
    }


    //分页 ： 导入插件 +配置
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
/**

    @Bean //逻辑删除
    public ISqlInjector sqlInjector(){return  new LogicSqlInjector();
    }*/

}
