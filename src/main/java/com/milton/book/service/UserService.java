package com.milton.book.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.milton.book.model.User;
import com.milton.book.repository.UserRepository;

@Service
@Transactional
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =userRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("Email "+username+" not found"));
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),getAuthorities(user));
	}
	private Collection<? extends GrantedAuthority> getAuthorities(User user) {
	String[]userRoles = user.getRoles().stream().map((role)->role.getName()).toArray(String[]::new);
		Collection<GrantedAuthority>authorities = AuthorityUtils.createAuthorityList(userRoles);
		return authorities;
	}

	public void createUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	public void updateUser(User user) {
		userRepository.save(user);
	}
	public User findByName(String name) {
		Optional<User>optional = userRepository.findByEmail(name);
		User user = optional.get();
		return user;
	}
	public User findById(long id) {
		Optional<User>optional = userRepository.findById(id);
		User user = optional.get();
		return user;
	}
	
	
	
	
	
	
}
