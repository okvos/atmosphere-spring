package com.okvos.atmosphere.data.feed;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FeedDbConfig {

    @Bean
    @ConfigurationProperties("spring.feed-datasource")
    public DataSourceProperties feedDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource feedDataSource() {
        return feedDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

}
