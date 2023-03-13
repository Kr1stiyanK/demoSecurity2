package com.example.demosecurity2.models.entities;

import javax.persistence.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Entity
@Component
@Table(name = "users")
public class UserEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String email;

  private String password;
  @Column(nullable = false)
  private String username;

  @ManyToMany(fetch = FetchType.EAGER)
  private List<UserRoleEntity> userRoles = new ArrayList<>();

  public String getEmail() {
    return email;
  }

  public UserEntity setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public UserEntity setPassword(String password) {
    this.password = password;
    return this;
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<UserRoleEntity> getUserRoles() {
    return userRoles;
  }

  public UserEntity setUserRoles(List<UserRoleEntity> userRoles) {
    this.userRoles = userRoles;
    return this;
  }

  public UserEntity addRole(UserRoleEntity userRole) {
    this.userRoles.add(userRole);
    return this;
  }

  @Override
  public String toString() {
    return "UserEntity{" +
            "id=" + id +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", username='" + username + '\'' +
            ", userRoles=" + userRoles +
            '}';
  }
}
