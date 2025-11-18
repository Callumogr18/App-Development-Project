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
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    private boolean enabled = true;
    private boolean accountNonExpired = true;
    private boolean credentialsNonExpired = true;
    private boolean accountNonLocked = true;

    public enum Role {
        ADMIN, STAFF, STUDENT
    }

    public Long getUserId(){
        return this.userId;
    }
    public String getPassword(){
        return this.password;
    }

    public Role getRole(){
        return this.role;
    }

    public String getUsername(){
        return this.username;
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



}
