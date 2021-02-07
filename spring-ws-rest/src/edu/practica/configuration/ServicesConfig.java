package edu.practica.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"edu.practica.service", "edu.practica.web"})
public class ServicesConfig {

}
