/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.redrisegames.reigninwildWeb.ui;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.redrisegames.reigninwildWeb.dao.EmailsDao;
import com.redrisegames.reigninwildWeb.dao.IEmailsDao;
import com.redrisegames.reigninwildWeb.dao.IMediaDao;
import com.redrisegames.reigninwildWeb.dao.INewsDao;
import com.redrisegames.reigninwildWeb.dao.IUsersDao;
import com.redrisegames.reigninwildWeb.dao.MediaDao;
import com.redrisegames.reigninwildWeb.dao.NewsDao;
import com.redrisegames.reigninwildWeb.dao.UsersDao;
import com.redrisegames.reigninwildWeb.orm.Users;
import com.redrisegames.reigninwildWeb.services.IUsersService;
import com.redrisegames.reigninwildWeb.services.UsersService;



@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.redrisegames.reigninwildWeb")
@EntityScan(basePackages = "com.redrisegames.reigninwildWeb.orm")
public class SampleWebUiApplication extends SpringBootServletInitializer{


	
	   @Bean
	    public HibernateTemplate hibernateTemplate() {
	       HibernateTemplate ht = new HibernateTemplate(sessionFactory()); 
	       ht.setCheckWriteOperations(false);
	        return ht;
	    }
	   
	   
	    @Value("${spring.datasource.url}")
	    private String url;
	    @Value("${spring.datasource.username}")
	    private String username;
	    @Value("${spring.datasource.password}")
	    private String password;
	    @Value("${spring.datasource.driver-class-name}")
	    private String driver;
	   @Bean
	    public DataSource getDataSource() {
	        BasicDataSource dataSource = new BasicDataSource();
	        dataSource.setDriverClassName(driver);
	        dataSource.setUrl(url);
	        dataSource.setUsername(username);
	        dataSource.setPassword(password);
	     
	        return dataSource;
	    }
	   
	    @Bean
	    public SessionFactory sessionFactory() {
	        BasicDataSource dataSource = new BasicDataSource();
	        
	        return new LocalSessionFactoryBuilder(getDataSource())
	           .addAnnotatedClasses(SampleWebUiApplication.class)
	           .buildSessionFactory();
	    }
	    
	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(SampleWebUiApplication.class);
	    }
	 
	    
	    @Bean  
	    public IEmailsDao emailsDao() {  
	       return new EmailsDao();  
	    }
	    
	    @Bean  
	    public INewsDao newsDao() {  
	       return new NewsDao();  
	    }
	    
	    @Bean  
	    public IUsersDao usersDao() {  
	       return new UsersDao();  
	    }
	    
	    @Bean  
        public IMediaDao mediaDao() {  
           return new MediaDao();  
        }
	
	    
	    
	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        LocalContainerEntityManagerFactoryBean entityManagerFactory =
	                new LocalContainerEntityManagerFactoryBean();

	        entityManagerFactory.setDataSource(getDataSource());

	        // Classpath scanning of @Component, @Service, etc annotated class
	        entityManagerFactory.setPackagesToScan("com.redrisegames.reigninwildWeb.orm");

	        // Vendor adapter
	        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);


	        return entityManagerFactory;
	    }

	    @Bean
	    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	        return new PersistenceExceptionTranslationPostProcessor();
	    }
	    
	    
	    
	    @Bean
	    public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
	         HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
	         factory.setEntityManagerFactory(emf);
	         return factory;
	    }
	    
	    
	    

	    
	    
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleWebUiApplication.class, args);
	}
	



  

	

}
