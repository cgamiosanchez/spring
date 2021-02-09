package edu.practica.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import edu.practica.domain.AuthenticationRequest;
import edu.practica.domain.AuthenticationResponse;
import edu.practica.service.impl.JwtService;
import edu.practica.service.impl.UserService;

@Service
@Path("")
public class UserResources {
	
	@Autowired
	AuthenticationManager authenticationManager;
    
	@Autowired
	@Qualifier("userServiceCustom")
	UserService userServiceCustom;
	
    @Autowired
    JwtService jwtService;

    @POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public AuthenticationResponse createToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid username or password", e);
        }
        UserDetails userDetails = userServiceCustom.loadUserByUsername(authenticationRequest.getUsername());
        String token = jwtService.createToken(userDetails);
        return new AuthenticationResponse(token);
    }
}