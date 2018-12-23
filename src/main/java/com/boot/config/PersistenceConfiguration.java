package com.boot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.core.env.Environment;

@Configuration
public class PersistenceConfiguration {
    @Autowired
    private Environment env;

    @Bean
//    @ConfigurationProperties(prefix="spring.datasource")
    @Primary
    public DataSource dataSource() {
        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));

        return dataSource;
    }

//    @Bean
////    @ConfigurationProperties(prefix="datasource.flyway")
//    @FlywayDataSource
//    public DataSource flywayDataSource() {
////        return DataSourceBuilder.create().build();
//        DriverManagerDataSource dataSource
//                = new DriverManagerDataSource();
//        dataSource.setDriverClassName(
//                env.getProperty("datasource.flyway.driver-class-name"));
//        dataSource.setUrl(env.getProperty("datasource.flyway.url"));
//        dataSource.setUsername(env.getProperty("datasource.flyway.username"));
//        dataSource.setPassword(env.getProperty("datasource.flyway.password"));
//
//        return dataSource;
//    }
}
