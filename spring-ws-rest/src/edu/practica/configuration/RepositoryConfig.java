package edu.practica.configuration;

import java.sql.SQLException;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"edu.practica.repository"})
@EnableTransactionManagement
public class RepositoryConfig {

	@Bean
	public DataSource getDataSource() throws NamingException, SQLException {
	
	   System.out.println("Iniciando conexion a datasource");
       Context initialContext = new InitialContext();
       DataSource dataSource =  (DataSource) initialContext.lookup("java:comp/env/bifnetempresa");
       if (dataSource == null) {
        System.out.println("No encuentra datasource.");
       }
       System.out.println("Fin instancia de conexion a datasource(ds):"+dataSource);
       return dataSource;
   }
	
	@Bean
	public PlatformTransactionManager transactionManager() throws NamingException, SQLException {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject() );
	    return transactionManager;
	}
	
	
	@SuppressWarnings("serial")
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws NamingException, SQLException {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(getDataSource());
        localContainerEntityManagerFactoryBean.setJpaDialect(new EclipseLinkJpaDialect());
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
        localContainerEntityManagerFactoryBean.setPackagesToScan("edu.practica.entity");
        localContainerEntityManagerFactoryBean.setJpaPropertyMap(
                new HashMap<String, String>() {
                    {
                        put("eclipselink.weaving", "false");
                    }
                });
        return localContainerEntityManagerFactoryBean;
    }
}
