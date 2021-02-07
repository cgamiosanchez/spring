package edu.practica.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(value = {
       ServicesConfig.class,
       RepositoryConfig.class,
       WSRSConfig.class
})
public class RootConfig {

}
