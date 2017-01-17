package com.tcs.mmisamples.customerprofile.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by SSasidharan on 2017/01/03.
 * CORS configuration class for Spring MVC.
 */
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class CustomerProfileRepositoryConfig {

    private static final String JNDI_NAME = "jdbc/customer";


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    @Primary
    @Resource(name = JNDI_NAME)
    public DataSource dataSource() {

        JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
        jndiDataSourceLookup.setResourceRef(true);
        DataSource dataSource = jndiDataSourceLookup.getDataSource(JNDI_NAME);
        return dataSource;

    }

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        return jdbcTemplate;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        dataSourceInitializer.setEnabled(true);
        return dataSourceInitializer;
    }
}
