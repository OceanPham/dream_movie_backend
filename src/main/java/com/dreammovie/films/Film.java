package com.dreammovie.films;

import java.math.BigInteger;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.dreammovie.supplier.Supplier;
import com.dreammovie.category.Category;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
@Entity // Đánh dấu lớp này là một entity JPA(đối tượng cơ sở dữ liệu)
@Table(name = "phims")
public class Film {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    // Foreign key to Category (TheLoai)
    @ManyToOne // Lazy fetching for performance
    @JoinColumn(name = "id_theloai", nullable = false)  // Define the foreign key column
    private Category category;

    // Foreign key to Supplier (NhaCungCap)
    @ManyToOne
    @JoinColumn(name = "id_nhacungcap", nullable = false)
    private Supplier supplier;

    @Column (nullable = false)
    private String name;
    
    @Column (nullable = false)
    private Time thoiluong;

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

    public Film() {
    }

    public Film(BigInteger id, Category category, Supplier supplier, String name, Time thoiluong, LocalDate ngaycongchieu, String trangthai, String mota, String duongdan, String hinhanh, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt ) {
        this.id = id;
        this.category = category;
        this.supplier = supplier;
        this.name = name;
        this.thoiluong = thoiluong;
        this.ngaycongchieu = ngaycongchieu;
        this.trangthai = trangthai;
        this.mota = mota;
        this.duongdan = duongdan;
        this.hinhanh = hinhanh;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getThoiluong() {
        return thoiluong;
    }

    public void setThoiluong(Time thoiluong) {
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
