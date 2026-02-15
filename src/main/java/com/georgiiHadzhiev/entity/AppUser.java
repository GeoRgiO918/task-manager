package com.georgiiHadzhiev.entity;

import javax.persistence.*;

@Table(name = "app_user")
@Entity
public class AppUser {

     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Id
     private Long id;

     @Column(name ="username",nullable = false,unique = true)
     private String username;

     @Column(name ="password",nullable = false)
     private String password;

     //Пока что делаем строкой - в дальейшем можно например сделать ссылкой на сущность
     //и добавить более сложную логику ролей
     @Column(name = "role",nullable = false)
     private String role;


     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public String getRole() {
          return role;
     }

     public void setRole(String role) {
          this.role = role;
     }

     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }
}
