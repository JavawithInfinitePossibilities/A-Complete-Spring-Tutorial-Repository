package com.tutorials.sid.spring.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kunmu On 28-12-2023
 * Do i need separate EntityManagerFactory and PlatformTransactionManager for each datasource?
 * ANS:
 * Yes, you need a separate EntityManagerFactory and PlatformTransactionManager
 *  for each datasource. Here's why: EntityManagerFactory is bound to exactly one DataSource.
 *  It holds the connection pool reference, the entity mappings, and the Hibernate
 *  SessionFactory for that specific database. You can't share one across two
 *  different databases. PlatformTransactionManager is bound to exactly one EntityManagerFactory.
 *  It manages commit/rollback for that specific persistence context. If two datasources share
 *  one transaction manager, it won't know which database to commit to.
 */
@Configuration
public class DataSourceConfigDetails {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.secondary.datasource")
    public DataSource springDataRepository() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource springDataRepository) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(springDataRepository);
        em.setPackagesToScan("com.tutorials.sid.spring.model.db");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(false);                                              // spring.jpa.show-sql=true
        vendorAdapter.setGenerateDdl(true);                                          // spring.jpa.generate-ddl=true
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");    // spring.jpa.properties.hibernate.dialect
        em.setJpaVendorAdapter(vendorAdapter);

        // Extra Hibernate properties (equivalent to spring.jpa.properties.hibernate.*)
        Map<String, Object> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.format_sql", false);       // spring.jpa.properties.hibernate.format_sql=true
        jpaProperties.put("hibernate.hbm2ddl.auto", "update"); // spring.jpa.hibernate.ddl-auto=update
        em.setJpaPropertyMap(jpaProperties);

        return em;
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource springCoreRepository() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryWithSecondaryDataSource(
            @Qualifier("springCoreRepository") DataSource dataSource,
            JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.tutorials.sid.spring.model.db");
        em.setJpaVendorAdapter(jpaVendorAdapter);
        return em;
    }

    @Bean
    public PlatformTransactionManager secondaryTransactionManager(
            @Qualifier("entityManagerFactoryWithSecondaryDataSource") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
