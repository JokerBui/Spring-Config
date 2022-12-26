package com.example.baitap5.configuration;

import com.example.baitap5.sach.entity.Sach;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Objects;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.baitap5.sach.repository",
                        entityManagerFactoryRef = "sachEntityManagerFactory",
                        transactionManagerRef = "sachTransactionManager")

public class SachDataSourceConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.sach")
    public DataSourceProperties sachDataSourceProperties(){

        return new DataSourceProperties();
    }
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.sach.configuration")
    public DataSource sachDataSource(){
        return sachDataSourceProperties()
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean sachEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(sachDataSource())
                .packages(Sach.class)
                .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager sachTransactionManager(final @Qualifier("sachEntityManagerFactory") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean){
        return new JpaTransactionManager(Objects.requireNonNull(localContainerEntityManagerFactoryBean.getObject()));
    }

    @Bean
    public EntityManagerFactoryBuilder builder()  {
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
    }
}
