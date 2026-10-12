package com.example.studentcrud;

import com.example.studentcrud.model.Student;
import com.example.studentcrud.repo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(StudentRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                Student s1 = new Student();
                s1.setName("John Doe");
                s1.setEmail("john@gmail.com");
                s1.setCourse("CS");
                s1.setPhone("9876543210");
                repo.save(s1);

                Student s2 = new Student();
                s2.setName("Jane Smith");
                s2.setEmail("jane@gmail.com");
                s2.setCourse("IT");
                s2.setPhone("9123456780");
                repo.save(s2);

                Student s3 = new Student();
                s3.setName("Alice Johnson");
                s3.setEmail("alice@gmail.com");
                s3.setCourse("CE");
                s3.setPhone("9234567890");
                repo.save(s3);
            }
        };
    }
}