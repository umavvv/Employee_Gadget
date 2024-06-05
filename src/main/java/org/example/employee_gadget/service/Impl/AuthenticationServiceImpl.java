package org.example.employee_gadget.service.Impl;

import org.example.employee_gadget.dto.AuthenticationDto;
import org.example.employee_gadget.entity.Employee;
import org.example.employee_gadget.repository.EmployeeRepository;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationServiceImpl {
    private final EmployeeRepository employeeRepository;

    public AuthenticationServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String authentication(AuthenticationDto authenticationDto) {
        Employee employee = employeeRepository.findById(authenticationDto.getId()).get();
        if (employee.getGmail().equals(authenticationDto.getGmail()) && employee.getPassword().equals(authenticationDto.getPassword())) {
            return "Success";
        } else {
            return "Fail";
        }
    }
}
