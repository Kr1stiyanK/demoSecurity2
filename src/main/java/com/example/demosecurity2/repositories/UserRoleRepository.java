package com.example.demosecurity2.repositories;

import com.example.demosecurity2.models.entities.UserRoleEntity;
//import com.example.security.model.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {

}
