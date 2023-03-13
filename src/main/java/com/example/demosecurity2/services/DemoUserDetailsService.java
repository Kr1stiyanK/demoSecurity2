package com.example.demosecurity2.services;

import com.example.demosecurity2.models.entities.UserEntity;
import com.example.demosecurity2.models.entities.UserRoleEntity;
import com.example.demosecurity2.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class DemoUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public DemoUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findUserEntityByUsername(username).map(this::map).orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found!"));
    }

    private UserDetails map(UserEntity userEntity){
        return new User(userEntity.getUsername(),userEntity.getPassword(),extractAuthorities(userEntity));
    }


    private List<GrantedAuthority> extractAuthorities(UserEntity userEntity){
        return userEntity.getUserRoles().stream().map(this::mapRole).toList();
    }


    private GrantedAuthority mapRole(UserRoleEntity userRole){
        return new SimpleGrantedAuthority("ROLE_" + userRole.getUserRole().name());
    }
}
