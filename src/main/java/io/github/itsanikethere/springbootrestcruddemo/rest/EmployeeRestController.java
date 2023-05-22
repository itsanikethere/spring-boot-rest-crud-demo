package io.github.itsanikethere.springbootrestcruddemo.rest;

import io.github.itsanikethere.springbootrestcruddemo.entity.Employee;
import io.github.itsanikethere.springbootrestcruddemo.service.EmployeeService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployeeList() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.findById(id);

        if (employee == null)
            throw new NullPointerException("No employee found with id: " + id);

        return employee;
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee) {
        if (employee.getId() != 0)
            throw new RuntimeException("Employee id not allowed here.");

        employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        if (employee.getId() == 0)
            throw new RuntimeException("No employee id found.");

        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteById(id);
    }

}
