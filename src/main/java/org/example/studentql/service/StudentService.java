package org.example.studentql.service;

import org.example.studentql.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto saveStudent(StudentDto studentDto);

    // Delete a student by ID
    boolean deleteStudent(Long id);

    // Find students by name
    List<StudentDto> getStudentsByName(String name);

    // Find students by email
    List<StudentDto> getStudentsByEmail(String email);

    // Find students by date of birth
    List<StudentDto> getStudentsByDateDeNaissance(String dateDeNaissance);

    // Find students by name, email, and date of birth
    List<StudentDto> getStudentsByNameAndEmailAndDateDeNaissance(String name, String email, String dateDeNaissance);

    // Save a list of students
    List<StudentDto> saveStudents(List<StudentDto> studentDtos);
}
