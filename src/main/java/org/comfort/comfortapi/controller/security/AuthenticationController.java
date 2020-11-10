package org.comfort.comfortapi.controller.security;

import javax.validation.Valid;

import org.comfort.comfortapi.config.security.TokenService;
import org.comfort.comfortapi.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<?> authenticate(@RequestBody @Valid LoginDto form) {
		UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(form.getEmail(),
				form.getPassword());
		try {
			Authentication authentication = authManager.authenticate(login);

			String token = tokenService.buildToken(authentication);

			return ResponseEntity.ok().build();
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}

	}

}
