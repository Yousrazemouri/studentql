package org.example.studentql.web;

import lombok.AllArgsConstructor;
import org.example.studentql.dto.StudentDto;
import org.example.studentql.service.StudentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentGraphQlController {

    private final StudentService studentService;

    @MutationMapping
    public StudentDto saveStudent(@Argument StudentDto student) {
        return studentService.saveStudent(student);
    }

    @MutationMapping
    public Boolean deleteStudent(@Argument Long id) {
        return studentService.deleteStudent(id);
    }

    @QueryMapping
    public List<StudentDto> getStudentsByName(@Argument String name) {
        return studentService.getStudentsByName(name);
    }

    @QueryMapping
    public List<StudentDto> getStudentsByEmail(@Argument String email) {
        return studentService.getStudentsByEmail(email);
    }

    @QueryMapping
    public List<StudentDto> getStudentsByDateDeNaissance(@Argument String dateDeNaissance) {
        return studentService.getStudentsByDateDeNaissance(dateDeNaissance);
    }

    @QueryMapping
    public List<StudentDto> getStudentsByNameAndEmailAndDateDeNaissance(
            @Argument String name,
            @Argument String email,
            @Argument String dateDeNaissance
    ) {
        return studentService.getStudentsByNameAndEmailAndDateDeNaissance(name, email, dateDeNaissance);
    }
}
