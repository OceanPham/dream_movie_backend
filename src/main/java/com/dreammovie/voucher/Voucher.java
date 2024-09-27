package com.dreammovie.voucher;
import com.dreammovie.employee.Employee;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; // Import annotation

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "vouchers")
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "employee_id", nullable = false)
//    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonIgnoreProperties("vouchers") // Loại bỏ trường "vouchers" khi tuần tự hóa dữ liệu từ phía Voucher
    private Employee employee;

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

    public Voucher(Long id, Employee employee, BigDecimal ti_le_chiet_khau, BigDecimal han_muc, Boolean tinh_trang, LocalDateTime ngay_tao, LocalDateTime han_dung) {
        this.id = id;
        this.employee = employee;
        this.ti_le_chiet_khau = ti_le_chiet_khau;
        this.han_muc = han_muc;
        this.tinh_trang = tinh_trang;
        this.ngay_tao = ngay_tao;
        this.han_dung = han_dung;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
