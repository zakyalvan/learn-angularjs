package com.innovez.core.config;

import javax.sql.DataSource;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.innovez.core.dto.Idea;
import com.innovez.core.entity.IdeaEntity;
import com.innovez.core.notif.NotificationConfigurerAspect;

/**
 * Core application context configuration.
 * 
 * @author zakyalvan
 *
 */
@Configuration
@ComponentScan(basePackages="com.innovez.core")
@EnableJpaRepositories(basePackages="com.innovez.core.repo")
@EnableTransactionManagement
public class CoreAppConfig {
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = 
				new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setPersistenceUnitName("innovezPersistenceUnit");
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan("com.innovez.core.entity");
		return entityManagerFactoryBean;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
	
	@Bean
	public NotificationConfigurerAspect notificationConfigurerAspect() {
		return NotificationConfigurerAspect.aspectOf();
	}
	
	@Bean
	public BeanMappingBuilder beanMappingBuilder() {
		return new BeanMappingBuilder() {
			@Override
			protected void configure() {
				mapping(IdeaEntity.class, Idea.class);
			}
		};
	}
	@Bean
	public DozerBeanMapper beanMapper() {
		DozerBeanMapper beanMapper = new DozerBeanMapper();
		beanMapper.addMapping(beanMappingBuilder());
		return beanMapper;
	}
}
