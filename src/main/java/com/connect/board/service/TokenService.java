package com.connect.board.service;

import java.util.Date;

import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

public interface TokenService extends PersistentTokenRepository{

	public void createNewToken(PersistentRememberMeToken token);
	public void updateToken(String series, String value, Date lastUsed);
	public PersistentRememberMeToken getTokenForSeries(String seriesId);
	public void removeUserTokens(String username);
}
