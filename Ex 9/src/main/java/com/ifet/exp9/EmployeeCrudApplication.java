package com.ifet.exp9;

import com.ifet.exp9.model.Employee;
import com.ifet.exp9.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(EmployeeRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Employee("John Doe", "john@example.com", "IT", 50000));
                repo.save(new Employee("Jane Smith", "jane@example.com", "HR", 60000));
                repo.save(new Employee("Bob Johnson", "bob@example.com", "Marketing", 45000));
                repo.save(new Employee("Mark Lee", "mark@example.com", "Sales", 55000));
            }
        };
    }
}