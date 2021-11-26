package com.xyz.dal;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "dbEntityManagerFactory", transactionManagerRef = "dbTransactionManager", basePackages = { "com.xyz.dal.repository" })
@PropertySource("classpath:database.properties")
public class AppConfig {

	public final static String PROP_HBM2DDL = "hibernate.hbm2ddl.auto";
	public final static String PROP_SHOW_SQL = "hibernate.show_sql";
	public final static String DB_PROP_PREFIX = "db.";

	@Autowired
	Environment environment;
	

	Map<String, String> hibernateProps() {
		Map<String, String> hibernateProps = new HashMap<>();
		hibernateProps.put(PROP_HBM2DDL, environment.getProperty(DB_PROP_PREFIX+PROP_HBM2DDL));
		hibernateProps.put(PROP_SHOW_SQL, environment.getProperty(DB_PROP_PREFIX+PROP_SHOW_SQL));
		return hibernateProps;
	}

	@Bean(name = "dataSource", destroyMethod = "close")
	@ConfigurationProperties(prefix = "db.datasource")
	DataSource dbDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "dbEntityManagerFactory")
	LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("dataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.xyz.dal.entity").properties(hibernateProps()).persistenceUnit("db").build();
	}
	
	@Primary
	@Bean(name = "dbTransactionManager")
	@Qualifier("dbTransactionManager")
	JpaTransactionManager transactionManager(@Qualifier("dbEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
