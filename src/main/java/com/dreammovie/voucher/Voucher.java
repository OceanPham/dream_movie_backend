package com.dreammovie.voucher;
import com.dreammovie.nhanvien.NhanVien;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "vouchers")
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "nhanvien_id", nullable = false)
    private NhanVien nhanVien;

    @Column (nullable = false)
    private BigDecimal ti_le_chiet_khau;

    @Column (nullable = false)
    private BigDecimal han_muc;

    @Column (nullable = false)
    private Boolean tinh_trang;

    @Column (nullable = false)
    private LocalDateTime ngay_tao;

    @Column (nullable = false)
    private LocalDateTime han_dung;

    // Timestamps for tracking creation, updates, and deletion
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime deletedAt;  // This is used for soft delete


    // Constructors


    public Voucher() {
    }

    public Voucher(Long id, NhanVien nhanVien, BigDecimal ti_le_chiet_khau, BigDecimal han_muc, Boolean tinh_trang, LocalDateTime ngay_tao, LocalDateTime han_dung, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.han_dung = han_dung;
        this.han_muc = han_muc;
        this.ngay_tao = ngay_tao;
        this.ti_le_chiet_khau = ti_le_chiet_khau;
        this.tinh_trang = tinh_trang;
        this.nhanVien = nhanVien;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public BigDecimal getTi_le_chiet_khau() {
        return ti_le_chiet_khau;
    }

    public void setTi_le_chiet_khau(BigDecimal ti_le_chiet_khau) {
        this.ti_le_chiet_khau = ti_le_chiet_khau;
    }

    public BigDecimal getHan_muc() {
        return han_muc;
    }

    public void setHan_muc(BigDecimal han_muc) {
        this.han_muc = han_muc;
    }

    public Boolean getTinh_trang() {
        return tinh_trang;
    }

    public void setTinh_trang(Boolean tinh_trang) {
        this.tinh_trang = tinh_trang;
    }

    public LocalDateTime getNgay_tao() {
        return ngay_tao;
    }

    public void setNgay_tao(LocalDateTime ngay_tao) {
        this.ngay_tao = ngay_tao;
    }

    public LocalDateTime getHan_dung() {
        return han_dung;
    }

    public void setHan_dung(LocalDateTime han_dung) {
        this.han_dung = han_dung;
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
