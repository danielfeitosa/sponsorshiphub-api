package org.comfort.comfortapi.config.security;

import java.util.Optional;

import org.comfort.comfortapi.model.security.User;
import org.comfort.comfortapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticationService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> userOptional = userRepository.findByEmail(username);
		if (userOptional.isPresent()) {
			return userOptional.get();
		}
		throw new UsernameNotFoundException("User not found");
	}

}
