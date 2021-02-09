package edu.practica.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import edu.practica.component.JwtAuthorizationFilter;
import edu.practica.service.impl.UserService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	@Qualifier("userServiceCustom")
	UserService userServiceCustom;
	
	@Override
 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("configureGlobal: "+userServiceCustom);
		System.out.println(auth);
		auth.userDetailsService(userServiceCustom).passwordEncoder(new BCryptPasswordEncoder());
		System.out.println("fin configureGlobal");
 	}
	
	@Autowired
    private JwtAuthorizationFilter jwtAuthorizationFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("configure");
		/*http.authorizeRequests().antMatchers("/**").hasRole("USER").and().httpBasic();
		http.csrf().disable();*/
		 http
         .csrf().disable()
         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         .and()
         .authorizeRequests().antMatchers("/login").permitAll()
         .anyRequest().authenticated()
         .and().addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
		System.out.println("fin configure");
		System.out.println(http);
	}
	
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
