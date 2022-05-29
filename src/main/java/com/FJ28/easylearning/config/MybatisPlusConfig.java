package com.FJ28.easylearning.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
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

}