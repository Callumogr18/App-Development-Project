package com.example.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "myusers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Getter
    @Column(unique = true, nullable = false)
    private String username;
    @Getter
    @Column(nullable = false)
    private String password;
    @Getter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.STUDENT;
    private boolean enabled = true;
    private boolean accountNonExpired = true;
    private boolean credentialsNonExpired = true;
    private boolean accountNonLocked = true;

    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(Role role){
        this.role = role;
    }

    public enum Role {
        ADMIN, STAFF, STUDENT
    }

    public Long getUserId(){
        return this.userId;
    }

    public Boolean isEnabled(){
        return this.enabled;
    }

    public Boolean isAccountNonExpired(){
        return this.accountNonExpired;
    }

    public Boolean isCredentialsNonExpired(){
        return this.credentialsNonExpired;
    }
    public Boolean isAccountNonLocked(){
        return this.accountNonLocked;
    }

    public void setUsername(String username){
        this.username = username;
    }




}
