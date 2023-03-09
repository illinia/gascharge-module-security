package com.gascharge.taemin.security.service;

import com.gascharge.taemin.domain.entity.user.User;
import com.gascharge.taemin.domain.repository.user.UserRepository;
import com.gascharge.taemin.security.entity.UserPrincipal;
import com.gascharge.taemin.security.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        log.info("loadUserByUsername email = {}", email);

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email : " + email));
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        userPrincipal.getAuthorities().stream().forEach(i -> System.out.println(i));

        return UserPrincipal.create(user);
    }

    public UserPrincipal loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return UserPrincipal.create(user);
    }
}
