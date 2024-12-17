package org.example.studentql.mapper;

import org.example.studentql.dao.entity.Student;
import org.example.studentql.dto.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    private final ModelMapper mapper = new ModelMapper();

    // Method to map from StudentDto to Student
    public Student fromStudentDtoToStudent(StudentDto studentDto) {
        return mapper.map(studentDto, Student.class);
    }

    // Method to map from Student to StudentDto
    public StudentDto fromStudentToStudentDto(Student student) {
        return mapper.map(student, StudentDto.class);
    }
}
