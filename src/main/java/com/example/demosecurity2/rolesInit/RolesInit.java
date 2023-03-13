package com.example.demosecurity2.rolesInit;

import com.example.demosecurity2.models.entities.UserEntity;
import com.example.demosecurity2.models.entities.UserRoleEntity;
import com.example.demosecurity2.models.enums.UserRoleEnum;
import com.example.demosecurity2.repositories.UserRepository;
import com.example.demosecurity2.repositories.UserRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RolesInit implements CommandLineRunner {

    private UserRoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    public RolesInit(UserRoleRepository roleRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        UserRoleEntity adminEntity = new UserRoleEntity().setUserRole(UserRoleEnum.ADMIN);
//        UserRoleEntity moderatorEntity = new UserRoleEntity().setUserRole(UserRoleEnum.MODERATOR);
//        UserRoleEntity userEntity = new UserRoleEntity().setUserRole(UserRoleEnum.USER);
//        List<UserRoleEntity> roles = new ArrayList<>();
//        roles.add(adminEntity);
//        roles.add(moderatorEntity);
//        roles.add(userEntity);
//        this.roleRepository.saveAll(roles);
//
//        initUser(List.of(userEntity,adminEntity,moderatorEntity));
    }

    private void initUser(List<UserRoleEntity> roles){
        UserEntity user = new UserEntity();
                user.setUserRoles(roles);
                user.setUsername("Userov");
                user.setEmail("user@example.com");
                user.setPassword(passwordEncoder.encode("topsecret"));

        this.userRepository.save(user);
    }
}
