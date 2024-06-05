package org.example.employee_gadget.controller;

import org.example.employee_gadget.dto.EmployeeDto;
import org.example.employee_gadget.service.Impl.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("/id")
    public EmployeeDto findById(@RequestParam Long id) {
        return employeeServiceImpl.findEmployeeById(id);
    }

    @GetMapping("/all")
    public List<EmployeeDto> findAll() {
        return employeeServiceImpl.findAllEmployee();
    }

    @PostMapping()
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeServiceImpl.saveEmployee(employeeDto));
    }

    @PutMapping()
    public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(employeeServiceImpl.updateEmployee(employeeDto));
    }

    @DeleteMapping()
    public String delete(@RequestParam Long id) {
        return employeeServiceImpl.deleteEmployee(id);
    }
}