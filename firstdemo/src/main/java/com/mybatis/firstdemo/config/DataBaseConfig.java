package com.mybatis.firstdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;

import java.io.IOException;

@Configuration
public class DataBaseConfig {
    //配置数据库
   @Bean
    public DruidDataSource getDataBase(){
    DruidDataSource druidDataSource=new DruidDataSource();
     druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//     druidDataSource.setUrl("jdbc:mysql://192.168.1.3:3306/cuishou3?useUnicode=true&rewriteBatchedStatements=true&characterEncoding=UTF-8");
//     druidDataSource.setUsername("zhaoqingkai");
//     druidDataSource.setPassword("zhaoqingkai123456");
     druidDataSource.setUrl("jdbc:mysql://localhost:3306/mybatislearn?useUnicode=true&rewriteBatchedStatements=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8");
     druidDataSource.setUsername("root");
     druidDataSource.setPassword("root");
     return druidDataSource;
    }
    //配置事务
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager=new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(getDataBase());
        return dataSourceTransactionManager;
    }
    @Bean(name = "sqlSessionFactoryBean")
    public SqlSessionFactoryBean getSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(getDataBase());
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*Mapper.xml"));
        return  sqlSessionFactoryBean;
    }
    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage("com.mybatis.firstdemo.dao");
        return  mapperScannerConfigurer;
    }

}
