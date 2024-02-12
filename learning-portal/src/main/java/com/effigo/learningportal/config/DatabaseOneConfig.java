/*
 * package com.effigo.learningportal.config;
 * 
 * import java.util.HashMap;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Qualifier; import
 * org.springframework.boot.context.properties.ConfigurationProperties; import
 * org.springframework.boot.jdbc.DataSourceBuilder; import
 * org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.data.jpa.repository.config.EnableJpaRepositories; import
 * org.springframework.orm.jpa.JpaTransactionManager; import
 * org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean; import
 * org.springframework.transaction.PlatformTransactionManager; import
 * org.springframework.transaction.annotation.EnableTransactionManagement;
 * 
 * import jakarta.persistence.EntityManagerFactory;
 * 
 * @Configuration
 * 
 * @EnableTransactionManagement
 * 
 * @EnableJpaRepositories(entityManagerFactoryRef = "db1EntityManagerFactory",
 * transactionManagerRef = "db1TransactionManager", basePackages =
 * "com.effigo.learningportal.repository") public class DatabaseOneConfig {
 * 
 * // datasource
 * 
 * @Bean
 * 
 * @ConfigurationProperties(prefix = "db1.datasource") public DataSource
 * DatabaseOneConfig() { return DataSourceBuilder.create().build(); }
 * 
 * // EntityMangaerFactory
 * 
 * @Bean public LocalContainerEntityManagerFactoryBean
 * db1EntityManagerFactory(EntityManagerFactoryBuilder emfb) {
 * 
 * // JPA properties HashMap<String, Object> properties = new HashMap<>();
 * properties.put("hibernate.hbm2ddl.auto", "update");
 * properties.put("hibernate.dialect",
 * "org.hibernate.dialect.PostgreSQLDialect");
 * properties.put("hibernate.show_sql", "true");
 * properties.put("hibernate.format_sql", "true");
 * 
 * return emfb.dataSource(DatabaseOneConfig()).packages(
 * "com.effigo.learningportal.model").properties(properties)
 * .persistenceUnit("portal").build(); }
 * 
 * // TransactionManagement
 * 
 * @Bean public PlatformTransactionManager db1TransactionManager(
 * 
 * @Qualifier("db1EntityManagerFactory") EntityManagerFactory factory) {
 * 
 * return new JpaTransactionManager(factory); }
 * 
 * }
 */