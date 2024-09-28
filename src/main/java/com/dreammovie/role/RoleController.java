package com.dreammovie.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:3000") // Cho phép các request từ frontend
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleRepository roleRepository;
    @GetMapping
    public List<Role> getAllRole(){
        return roleService.getAllActiveRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleId(@PathVariable Long id){
        Optional<Role> role = roleService.getRoleById(id);
        return role.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public Role addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }

    //Update
    @PutMapping("/{id}")
    public  ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role role){
        Role updated = roleService.updateRole(id, role);
        if(updated != null){
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
        return ResponseEntity.ok().build();
    }

}
