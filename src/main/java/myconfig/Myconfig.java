package myconfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import mymodel.Employee;
import mymodel.User;


@Configuration
@EnableWebMvc
@ComponentScan({"mycontroller", "mydao", "myservice", "myfilter"})
@EnableTransactionManagement
public class Myconfig implements WebMvcConfigurer {
	
	@Bean
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver ret = new InternalResourceViewResolver();
	    //bean.setViewClass(JstlView.class);
	    ret.setPrefix("/WEB-INF/views/");
	    ret.setSuffix(".jsp");
	    ret.setOrder(1);
	    return ret;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
	
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
	@Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename("classpath:messages");
        resource.setDefaultEncoding("UTF-8");
        return resource;
    }
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@//localhost:1521/xe");
	    dataSource.setUsername("SYSTEM");
	    dataSource.setPassword("12345678");
	 
	    return dataSource;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
	 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    sessionBuilder.addAnnotatedClasses(User.class, Employee.class);
	    sessionBuilder.addProperties(getHibernateProperties());
	 
	    return sessionBuilder.buildSessionFactory();
	}
	
	private Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	    return properties;
	}
	

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
	        SessionFactory sessionFactory) {
		
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(
	            sessionFactory);
	 
	    return transactionManager;
	}
	
	
	
	

	
	
}
