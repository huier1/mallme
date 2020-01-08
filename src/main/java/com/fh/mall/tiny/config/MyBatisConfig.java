package com.fh.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis配置类
 */
@Configuration
@MapperScan("com.fh.mall.tiny.mbg.mapper")
public class MyBatisConfig {
}
