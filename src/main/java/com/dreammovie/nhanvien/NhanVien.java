package com.dreammovie.nhanvien;
import com.dreammovie.voucher.Voucher;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "nhan_viens")
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String ten_dang_nhap_nv;

    @OneToMany(mappedBy = "nhanVien" , cascade =  CascadeType.ALL)
    private Set<Voucher> vouchers;

    //update code
//    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
//    private Set<Voucher> vouchers = new HashSet<>();


    // Timestamps for tracking creation, updates, and deletion
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime deletedAt;  // This is used for soft delete


    // Constructors

    public NhanVien(Long id, String ten_dang_nhap_nv, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.ten_dang_nhap_nv = ten_dang_nhap_nv;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public NhanVien() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTen_dang_nhap_nv() {
        return ten_dang_nhap_nv;
    }

    public void setTen_dang_nhap_nv(String ten_dang_nhap_nv) {
        this.ten_dang_nhap_nv = ten_dang_nhap_nv;
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
