package com.dreammovie.role;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.dreammovie.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; // Import annotation

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String role_name;

    // Bi-directional mapping
//    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
//    private Set<User> users;

    @OneToMany(mappedBy = "role" , cascade = CascadeType.ALL)
    @JsonIgnoreProperties("role") // Loại bỏ trường "employee" khi tuần tự hóa dữ liệu từ phía Employee
    private Set<User> users;

    @Column (nullable = false)
    private String description ;


    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime deletedAt;

    public Role() {
    }

    public Role(Long id, String role_name, String description) {
        this.id = id;
        this.role_name = role_name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
