package com.dreammovie.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin(origins = "http://localhost:3000") // Cho phép các request từ frontend
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    @Autowired
    private SupplierRepository supplierRepository;
    @GetMapping
    public List<Supplier> getAllSupplier(){
        return supplierService.getAllActiveSuppliers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id){
        Optional<Supplier> category = supplierService.getSupplierById(id);
        return category.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    //Add new
    @PostMapping
    public Supplier addSupplier(@RequestBody Supplier supplier){
        return supplierService.addSupplier(supplier);
    }

    //Update
    @PutMapping("/{id}")
    public  ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier){
        Supplier updated = supplierService.updateSupplier(id, supplier);
        if(updated != null){
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id){
        supplierService.deleteSupplier(id);
        return ResponseEntity.ok().build();
    }

}
