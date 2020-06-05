package com.jpaAuthentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.jpaAuthentication.entity.LogInUser;
import com.jpaAuthentication.entity.User;
import com.jpaAuthentication.entity.UserRole;
import com.jpaAuthentication.repository.UserRepository;
import com.jpaAuthentication.repository.UserRoleRepository;

@Service
public class LogInUserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
	UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User 404 Not Found");
		}
		
        UserRole userRole = userRoleRepository.findByuser(user);
        return new LogInUser(user, userRole);
    }
}
