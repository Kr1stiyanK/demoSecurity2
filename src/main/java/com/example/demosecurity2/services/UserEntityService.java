package com.example.demosecurity2.services;

import com.example.demosecurity2.models.entities.UserEntity;
import com.example.demosecurity2.models.entities.dtos.UserRegistrationDTO;
import com.example.demosecurity2.repositories.UserRepository;
import com.example.demosecurity2.repositories.UserRoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityService {
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final UserRoleRepository userRoleRepository;

    public UserEntityService(PasswordEncoder passwordEncoder, UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }


    public void register(UserRegistrationDTO userRegistrationDTO){

        UserEntity userToSave = new UserEntity();
                userToSave.setUsername(userRegistrationDTO.getUsername());
                userToSave.setEmail(userRegistrationDTO.getEmail());
                userToSave.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));

        this.userRepository.save(userToSave);
    }
}
