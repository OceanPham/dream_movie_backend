package com.dreammovie.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vouchers")
@CrossOrigin(origins = "http://localhost:3000")

public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @Autowired
    private VoucherRepository voucherRepository;

    @GetMapping
    public List<Voucher> getAllVoucher(){
        return voucherService.getAllActiveVouchers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voucher> getVoucherById(@PathVariable Long id){
        Optional<Voucher> category = voucherService.getVoucherById(id);
        return category.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public Voucher addVoucher(@RequestBody Voucher voucher){
        return voucherService.addVoucher(voucher);
    }

    //Update
    @PutMapping("/{id}")
    public  ResponseEntity<Voucher> updateVoucher(@PathVariable Long id, @RequestBody Voucher voucher){
        Voucher updated = voucherService.updateVoucher(id, voucher);
        if(updated != null){
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoucher(@PathVariable Long id){
        voucherService.deleteVoucher(id);
        return ResponseEntity.ok().build();
    }

}
