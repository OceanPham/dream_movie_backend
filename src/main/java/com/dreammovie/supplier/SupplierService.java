package com.dreammovie.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    // Lấy tất cả các loại ghế
//    public List<Supplier> getAllChairCategories(){
//        return supplierRepository.findAll();
//    }

    public List<Supplier> getAllActiveSuppliers() {
        // Only return records that are not soft deleted (deletedAt is null)
        return supplierRepository.findByDeletedAtIsNull();
    }

    public void softDeleteSupplier(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        // Set deletedAt to the current time to mark it as deleted
        supplier.setDeletedAt(LocalDateTime.now());
        supplierRepository.save(supplier);
    }

    // Lấy loại ghế theo ID
    public Optional<Supplier> getSupplierById (Long id){
        return supplierRepository.findById(id);
    }

    // Thêm mới loại ghế
    public Supplier addSupplier(Supplier supplier){
        return supplierRepository.save(supplier);
    }

    // Cập nhật loại ghế
    public Supplier updateSupplier (Long id, Supplier updateSupplier){
        Optional<Supplier> categoryOptional = supplierRepository.findById(id);
        if(categoryOptional.isPresent()){
            Supplier existingCategory = categoryOptional.get();
            existingCategory.setName(updateSupplier.getName());
            existingCategory.setDescription(updateSupplier.getDescription());

            return supplierRepository.save(existingCategory);
        }
        return null;
    }


    public void deleteSupplier (Long id){
        supplierRepository.deleteById(id);
    }
}
