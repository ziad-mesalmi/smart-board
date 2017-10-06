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

import com.connect.board.model.Utilisateur;
import com.connect.board.repo.UtilisateurRepository;

@Service
public class MongoDBAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private UtilisateurRepository users;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authenticationToken)
			throws AuthenticationException {

	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken credentiel)
			throws AuthenticationException {
		UserDetails loadedUser;
		try {
			Optional<Utilisateur> user = Optional.ofNullable(users.findByUsername(username));
			user.orElseThrow(() -> new InternalAuthenticationServiceException("Utilisatateur non existant"));
			user.filter(u -> u.getPassword().equals(credentiel.getCredentials())).orElseThrow(() -> new InternalAuthenticationServiceException("Mot de passe incorrect"));
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
			GrantedAuthority authority = () -> user.get().getRole();
			roles.add(authority);
			loadedUser = new User(user.get().getUsername(), user.get().getPassword(), roles);
		} catch (Exception repositoryProblem) {
			throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
		}
		return loadedUser;
	}
}
