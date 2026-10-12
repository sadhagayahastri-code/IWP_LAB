package com.ifet.exp9.service;

import com.ifet.exp9.model.Employee;
import com.ifet.exp9.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo){
        this.repo=repo;
    }

    public List<Employee> getAll(){
        return repo.findAll();
    }

    public Employee save(Employee emp){
        return repo.save(emp);
    }

    public Employee get(Long id){
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}