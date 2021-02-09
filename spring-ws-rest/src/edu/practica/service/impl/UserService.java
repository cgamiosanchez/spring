package edu.practica.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.practica.entity.UserRole;
import edu.practica.repository.UserRepository;

@Service("userServiceCustom")
public class UserService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername: "+username);
		edu.practica.entity.User user = userRepository.findByUsername(username);
		List<GrantedAuthority> auths = buildAuthorities(user.getUserRole());
		return buildUser(user, auths);
	}
	
	private User buildUser(edu.practica.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true ,true, authorities);
	}

	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles){
		List<GrantedAuthority> lista = new ArrayList<>();
		for(UserRole u : userRoles) {
			System.out.println("u.getRol(): "+u.getRol());
			lista.add(new SimpleGrantedAuthority(u.getRol()));
		}
		return lista;
	}
}
