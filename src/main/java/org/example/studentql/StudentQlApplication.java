package org.example.studentql;

import org.example.studentql.dto.StudentDto;
import org.example.studentql.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(scanBasePackages = "org.example.studentql")
public class StudentQlApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentQlApplication.class, args);
    }

    @Bean
    CommandLineRunner start(StudentService studentService) {
        return args -> {
            studentService.saveStudents(
                    List.of(
                            StudentDto.builder()
                                    .name("John Doe")
                                    .email("john.doe@example.com")
                                    .dateDeNaissance("1995-05-20")
                                    .build(),
                            StudentDto.builder()
                                    .name("Jane Smith")
                                    .email("jane.smith@example.com")
                                    .dateDeNaissance("1997-08-15")
                                    .build(),
                            StudentDto.builder()
                                    .name("Ali Hassan")
                                    .email("ali.hassan@example.com")
                                    .dateDeNaissance("2000-01-10")
                                    .build(),
                            StudentDto.builder()
                                    .name("Fatima Zahra")
                                    .email("fatima.zahra@example.com")
                                    .dateDeNaissance("1998-12-25")
                                    .build()
                    )
            );
        };
    }
}
