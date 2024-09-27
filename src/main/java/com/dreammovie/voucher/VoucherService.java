package com.dreammovie.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    public List<Voucher> getAllActiveVouchers() {
        return voucherRepository.findByDeletedAtIsNull();
    }

    public void softDeleteVoucher(Long id) {
        Voucher voucher = voucherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Voucher not found"));

        voucher.setDeletedAt(LocalDateTime.now());
        voucherRepository.save(voucher);
    }

    public Optional<Voucher> getVoucherById (Long id){
        return voucherRepository.findById(id);
    }

    public Voucher addVoucher(Voucher voucher){
        return voucherRepository.save(voucher);
    }

    public Voucher updateVoucher (Long id, Voucher updateVoucher){
        Optional<Voucher> voucherOptional = voucherRepository.findById(id);
        if(voucherOptional.isPresent()){
            Voucher existingVoucher = voucherOptional.get();
            existingVoucher.setEmployee(updateVoucher.getEmployee());
            existingVoucher.setTi_le_chiet_khau(updateVoucher.getTi_le_chiet_khau());
            existingVoucher.setHan_muc(updateVoucher.getHan_muc());
            existingVoucher.setTinh_trang(updateVoucher.getTinh_trang());
            existingVoucher.setNgay_tao(updateVoucher.getNgay_tao());
            existingVoucher.setHan_dung(updateVoucher.getHan_dung());

            return voucherRepository.save(existingVoucher);
        }
        return null;
    }

    public void deleteVoucher (Long id){
        voucherRepository.deleteById(id);
    }
}
