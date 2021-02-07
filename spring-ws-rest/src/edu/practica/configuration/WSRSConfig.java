package edu.practica.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.provider.BinaryDataProvider;
import org.apache.cxf.jaxrs.provider.DataBindingProvider;
import org.apache.cxf.jaxrs.provider.JAXBElementProvider;
import org.apache.cxf.jaxrs.provider.MultipartProvider;
import org.apache.cxf.jaxrs.provider.XPathProvider;
import org.apache.cxf.jaxws.EndpointImpl;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import edu.practica.endpoints.BancoServiceImpl;
import edu.practica.web.BancoResources;

@Configuration
@ComponentScan(basePackages= {"edu.practica.endpoints"})
public class WSRSConfig {
	 
	@Autowired
	BancoServiceImpl bancoServiceImpl;
	
	@Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }  
	
	@Bean
	public Endpoint endpoint() {
	    EndpointImpl endpoint = new EndpointImpl(springBus(), bancoServiceImpl);
	    endpoint.publish("/bancoServiceImpl");
        return endpoint;
	}

	@SuppressWarnings("serial")
	@Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
       
        // "alternative/additiona - ly":
           //marshaller.setContextPath(contextPath); (<jaxb.context-file>)
           marshaller.setPackagesToScan("edu.practica");

        marshaller.setMarshallerProperties(new HashMap<String, Object>() {{
          put(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
          // set more properties here...
        }});

        return marshaller;
    }
	
	@Autowired
	BancoResources bancoResources;
	
	@Bean
	public Server rsServer() {
		JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
	    factory.setServiceBeans(Arrays.<Object>asList(bancoResources));
	    factory.setAddress("/");
	    factory.setBus(springBus());
	    factory.setProviders(Arrays.<Object>asList(getProvider()));
	    return factory.create();
	}
	
	public static List<Object> getProvider() {
		List<Object> providers = new ArrayList<Object>();
		providers.add(new JAXBElementProvider<Object>());
		providers.add(new MultipartProvider());
		providers.add(new XPathProvider<Object>());
		providers.add(new DataBindingProvider<Object>());
		providers.add(new BinaryDataProvider<Object>());
		//providers.add(new JacksonJaxbJsonProvider());
		providers.add(new JacksonJsonProvider());
		return providers;
	}
}
