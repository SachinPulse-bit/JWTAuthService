package com.jwtauthservice.service;

import java.util.Collections;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwtauthservice.dto.CustomUserDetails;
import com.jwtauthservice.model.User;
import com.jwtauthservice.repository.UserRepository;

@Primary
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // Convert String role to GrantedAuthority
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());

		return new CustomUserDetails(user.getId(), user.getUsername(), user.getPassword(),
				Collections.singletonList(authority));
	}
    
}
