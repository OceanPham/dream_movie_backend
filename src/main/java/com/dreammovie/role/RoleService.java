package com.dreammovie.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllActiveRoles() {
        return roleRepository.findByDeletedAtIsNull();
    }

    public void softDeleteRole(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        role.setDeletedAt(LocalDateTime.now());
        roleRepository.save(role);
    }

    public Optional<Role> getRoleById (Long id){
        return roleRepository.findById(id);
    }

    public Role addRole(Role role){
        return roleRepository.save(role);
    }

    public Role updateRole (Long id, Role updateRole){
        Optional<Role> categoryOptional = roleRepository.findById(id);
        if(categoryOptional.isPresent()){
            Role existingRole = categoryOptional.get();
            existingRole.setRole_name(updateRole.getRole_name());
            existingRole.setDescription(updateRole.getDescription());

            return roleRepository.save(existingRole);
        }
        return null;
    }

    public void deleteRole (Long id){
        roleRepository.deleteById(id);
    }
}
