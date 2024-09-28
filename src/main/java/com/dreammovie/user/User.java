package com.dreammovie.user;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.dreammovie.role.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; // Import annotation

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "role_id", nullable = false)
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    @JsonIgnoreProperties("users")
    private Role role;

    @Column (nullable = false)
    private String full_name;

    @Column (nullable = false)
    private String gender;

    @Column (nullable = false)
    private LocalDateTime birth_day;

    @Column (nullable = false)
    private String home_town;

    @Column (nullable = false)
    private String email;

    @Column (nullable = false)
    private String phone;

    @Column (nullable = false)
    private String password;

    // Timestamps for tracking creation, updates, and deletion
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime deletedAt;  // This is used for soft delete


    public User() {
    }

    public User(Long id, Role role, String full_name, String gender, LocalDateTime birth_day, String home_town, String email, String phone, String password) {
        this.id = id;
        this.role = role;
        this.full_name = full_name;
        this.gender = gender;
        this.birth_day = birth_day;
        this.home_town = home_town;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(LocalDateTime birth_day) {
        this.birth_day = birth_day;
    }

    public String getHome_town() {
        return home_town;
    }

    public void setHome_town(String home_town) {
        this.home_town = home_town;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
