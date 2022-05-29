package com.FJ28.easylearning.config;

import com.FJ28.easylearning.entity.User;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.FJ28.easylearning.mapper")
@Configuration
public class MybatisPlusConfig {

    // OptimisticLockerInterceptor plugin
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {

        return new OptimisticLockerInterceptor();

    }

    //Pagination Plugin
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }


}