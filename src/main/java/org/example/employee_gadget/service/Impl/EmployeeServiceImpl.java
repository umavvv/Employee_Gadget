package org.example.employee_gadget.service.Impl;

import org.example.employee_gadget.dto.EmployeeDto;
import org.example.employee_gadget.entity.Employee;
import org.example.employee_gadget.repository.EmployeeRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDto employeeDtoConvert(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(employee.getName());
        employeeDto.setGmail(employee.getGmail());
        employeeDto.setSurname(employee.getSurname());
        employeeDto.setPatronymic(employee.getPatronymic());
        employeeDto.setPhoneNumber(employee.getPhoneNumber());
        return employeeDto;
    }

    public EmployeeDto findEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(employee.getName());
        employeeDto.setGmail(employee.getGmail());
        employeeDto.setSurname(employee.getSurname());
        employeeDto.setPatronymic(employee.getPatronymic());
        employeeDto.setPhoneNumber(employee.getPhoneNumber());
        return employeeDto;
    }

    public List<EmployeeDto> findAllEmployee() {
        return ((List<Employee>) employeeRepository
                .findAll())
                .stream()
                .map(this::employeeDtoConvert)
                .collect(Collectors.toList());
    }

    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setSurname(employeeDto.getSurname());
        employee.setName(employeeDto.getName());
        employee.setPatronymic(employeeDto.getPatronymic());
        employee.setGmail(employeeDto.getGmail());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employeeRepository.save(employee);
        return employeeDto;
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeDto.getId()).get();
        employee.setId(employeeDto.getId());
        employee.setSurname(employeeDto.getSurname());
        employee.setName(employeeDto.getName());
        employee.setPatronymic(employeeDto.getPatronymic());
        employee.setGmail(employeeDto.getGmail());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());

        employeeRepository.save(employee);
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setGmail(employee.getGmail());
        employeeDto.setSurname(employee.getSurname());
        employeeDto.setPatronymic(employee.getPatronymic());
        employeeDto.setPhoneNumber(employee.getPhoneNumber());
        return employeeDto;
    }

    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "Delete";

    }
}