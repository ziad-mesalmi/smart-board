package com.connect.board.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.security.authentication.InternalAuthenticationServiceException;  
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;  
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;  
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;  
import org.springframework.security.core.userdetails.UserDetails;  
import org.springframework.stereotype.Service;

import com.connect.board.repo.UserRepository;

@Service
public class MongoDBAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private UserRepository users;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authenticationToken)
			throws AuthenticationException {

	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken credentiel)
			throws AuthenticationException {
		UserDetails loadedUser;
		try {
			com.connect.board.model.User user = users.findByUsername(username);
			if(user == null) {
				throw new InternalAuthenticationServiceException("Utilisatateur non existant"); 
			}
			if(!user.getPassword().equals(credentiel.getCredentials())) {
				throw new InternalAuthenticationServiceException("Mot de passe incorrect"); 
			}
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
			GrantedAuthority authority = () -> user.getRole();
			roles.add(authority);
			loadedUser = new User(user.getUsername(), user.getPassword(), roles);
		} catch (Exception repositoryProblem) {
			throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
		}
		return loadedUser;
	}
}
