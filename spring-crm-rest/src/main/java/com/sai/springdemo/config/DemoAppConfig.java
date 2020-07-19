package com.sai.springdemo.config;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;



@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.sai.springdemo")
@PropertySource({ "classpath:persistence-mysql.properties" })
public class DemoAppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Value("${spring.datasource.driver-class-name:oracle.jdbc.pool.OracleDataSource}")
    private String driverClassName;

	@Bean
	public DataSource myDataSource() throws PropertyVetoException {
		 PoolDataSource pds = null;
		// create connection pool
		 pds = PoolDataSourceFactory.getPoolDataSource();

		 String url= "jdbc:oracle:thin:@//localhost:1521/XE";
		 
		 
		try {
			pds.setConnectionFactoryClassName(driverClassName);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// for sanity's sake, let's log url and user ... just to make sure we are reading the data
		//logger.info("jdbc.url=" + env.getProperty("jdbc.url"));
		//logger.info("jdbc.user=" + env.getProperty("jdbc.user"));
		
		// set database connection props
		try {
			
			
			// pds.setConnectionFactoryClassName(driverClassName);
			pds.setURL(url);
            pds.setUser("hr");
            pds.setPassword("hr");
            pds.setMinPoolSize(3);
            pds.setInitialPoolSize(2);
            pds.setMaxPoolSize(5);
            
            
			System.out.println("Connected to Data Source From Devconfig");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// set connection pool props
 

		return pds;
	}
	
	private Properties getHibernateProperties() {

		// set hibernate properties
		Properties props = new Properties();

		props.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
		props.setProperty("hibernate.show_sql", "show_sql");
		
		return props;				
	}

	
	// need a helper method 
	// read environment property and convert to int
	
	private int getIntProperty(String propName) {
		
		//String propVal = env.getProperty(propName);
		
		// now convert to int
	//	int intPropVal = Integer.parseInt(propVal);
		
		return  1;
	}	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		
		// create session factorys
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		try {
			// set the properties
			sessionFactory.setDataSource(myDataSource());
			sessionFactory.setPackagesToScan("com.sai.springdemo.entity");
			sessionFactory.setHibernateProperties(getHibernateProperties());
			System.out.println("Connected to Hibernate From Devconfig");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}	
	
	public static void main(String[] args) {
		DemoAppConfig appcon = new DemoAppConfig();
//		try {
			try {
				appcon.myDataSource();
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println("Connected to Data Source- From Main");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			appcon.sessionFactory();
//			System.out.println("Connected to Hibernate From Main");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		

	}
	
}









