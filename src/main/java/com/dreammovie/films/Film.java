package com.dreammovie.films;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Đánh dấu lớp này là một entity JPA(đối tượng cơ sở dữ liệu)
@Table(name = "phims")
public class Film {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column (nullable = false)
    private BigInteger matheloai;

    @Column (nullable = false)
    private BigInteger manhacungcap;

    @Column (nullable = false)
    private String name;
    
    @Column (nullable = false)
    private double thoiluong;

    @Column (nullable = false)
    private LocalDate ngaycongchieu;

    @Column (nullable = false)
    private String trangthai;

    @Column (nullable = false)
    private String mota;

    @Column (nullable = false)
    private String duongdan;

    @Column (nullable = false)
    private String hinhanh;

   // Timestamps for tracking creation, updates, and deletion
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime deletedAt;  // This is used for soft delete
    
    // Constructors
    public Film(){
    }

    public Film(BigInteger id, BigInteger matheloai, BigInteger manhacungcap, String name, double thoiluong, LocalDate ngaycongchieu, String trangthai, String mota, String duongdan, String hinhanh) {
        this.id = id;
        this.matheloai = matheloai;
        this.manhacungcap = manhacungcap;
        this.name = name;
        this.thoiluong = thoiluong;
        this.ngaycongchieu = ngaycongchieu;
        this.trangthai = trangthai;
        this.mota = mota;
        this.duongdan = duongdan;
        this.hinhanh = hinhanh;
    }
    
    // Các phương thức getter và setter

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getMatheloai() {
        return matheloai;
    }

    public void setMatheloai(BigInteger matheloai) {
        this.matheloai = matheloai;
    }

    public BigInteger getManhacungcap() {
        return manhacungcap;
    }

    public void setManhacungcap(BigInteger manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getThoiluong() {
        return thoiluong;
    }

    public void setThoiluong(double thoiluong) {
        this.thoiluong = thoiluong;
    }

    public LocalDate getNgaycongchieu() {
        return ngaycongchieu;
    }

    public void setNgaycongchieu(LocalDate ngaycongchieu) {
        this.ngaycongchieu = ngaycongchieu;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getDuongdan() {
        return duongdan;
    }

    public void setDuongdan(String duongdan) {
        this.duongdan = duongdan;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
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
