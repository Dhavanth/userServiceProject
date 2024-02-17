package org.example.userserviceproject.security.services;

import org.example.userserviceproject.models.User;
import org.example.userserviceproject.repositories.UserRepository;
import org.example.userserviceproject.security.models.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        if(optionalUser.isEmpty()){
            throw new UsernameNotFoundException("User with username: " + username +"does not exist");
        }

        CustomUserDetails customUserDetails = new CustomUserDetails(optionalUser.get());

        return customUserDetails;
    }
}
