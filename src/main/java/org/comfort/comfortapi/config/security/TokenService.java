package org.comfort.comfortapi.config.security;

import java.util.Calendar;
import java.util.Date;

import org.comfort.comfortapi.model.security.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	@Value("${sponsorship.jwt.expiration}")
	private String expiration;
	@Value("${sponsorship.jwt.secret}")
	private String secret;

	public String buildToken(Authentication authentication) {
		User user = (User) authentication.getPrincipal();

		String id = user.getId().toString();
		Calendar calendar = Calendar.getInstance();
		Date today = calendar.getTime();

		Date dateExpiration = new Date(today.getTime() + Long.parseLong(expiration));

		return Jwts.builder().setIssuer("API agenda produto").setSubject(id).setExpiration(dateExpiration)
				.setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, secret).compact();
	}

}
