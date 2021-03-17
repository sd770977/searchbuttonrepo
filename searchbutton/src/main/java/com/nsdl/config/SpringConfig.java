package com.nsdl.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.nsdl.*" })
public class SpringConfig implements WebMvcConfigurer {

	@Bean
	public DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:postgresql://localhost:5432/demo");
		ds.setUsername("postgres");
		ds.setPassword("sd30");
		ds.setDriverClassName("org.postgresql.Driver");
		return ds;
	}

	@Bean
	public LocalSessionFactoryBean getLocalSessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(getDataSource()); // datasource-->database configuration
		Properties hibernateProps = new Properties();
		hibernateProps.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

		hibernateProps.put(Environment.SHOW_SQL, true);
		hibernateProps.put(Environment.HBM2DDL_AUTO, "update");
		factory.setHibernateProperties(hibernateProps);
		factory.setPackagesToScan("com.nsdl.entity");
		return factory;
	}

	@Bean
	public InternalResourceViewResolver spViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}
