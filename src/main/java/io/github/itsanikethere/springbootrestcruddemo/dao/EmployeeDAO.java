package io.github.itsanikethere.springbootrestcruddemo.dao;

import io.github.itsanikethere.springbootrestcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

}
