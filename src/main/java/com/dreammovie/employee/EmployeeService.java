package com.dreammovie.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllActiveEmployees() {
        return employeeRepository.findByDeletedAtIsNull();
    }
    public void softDeleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setDeletedAt(LocalDateTime.now());
        employeeRepository.save(employee);
    }
    public Optional<Employee> getEmployeeById (Long id){
        return employeeRepository.findById(id);
    }
    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public Employee updateEmployee (Long id, Employee updateEmployee){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            Employee existingEmployee = employeeOptional.get();
            existingEmployee.setUsername(updateEmployee.getUsername());
            existingEmployee.setFullname(updateEmployee.getFullname());
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }
    public void deleteEmployee (Long id){
        employeeRepository.deleteById(id);
    }
}
