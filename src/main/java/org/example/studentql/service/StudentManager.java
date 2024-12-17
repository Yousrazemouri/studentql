package org.example.studentql.service;

import lombok.AllArgsConstructor;

import org.example.studentql.dao.entity.Student;
import org.example.studentql.dao.repository.StudentRepository;
import org.example.studentql.dto.StudentDto;
import org.example.studentql.mapper.StudentMapper;
import org.example.studentql.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentManager implements StudentService {

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        // Map DTO to entity
        Student student = studentMapper.fromStudentDtoToStudent(studentDto);

        // Save entity to the repository
        student = studentRepository.save(student);

        // Map entity back to DTO and return
        return studentMapper.fromStudentToStudentDto(student);
    }

    @Override
    public boolean deleteStudent(Long id) {
        try {
            studentRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public List<StudentDto> getStudentsByName(String name) {
        List<Student> students = studentRepository.findByName(name);
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            studentDtos.add(studentMapper.fromStudentToStudentDto(student));
        }
        return studentDtos;
    }

    @Override
    public List<StudentDto> getStudentsByEmail(String email) {
        List<Student> students = studentRepository.findByEmail(email);
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            studentDtos.add(studentMapper.fromStudentToStudentDto(student));
        }
        return studentDtos;
    }

    @Override
    public List<StudentDto> getStudentsByDateDeNaissance(String dateDeNaissance) {
        List<Student> students = studentRepository.findByDateDeNaissance(dateDeNaissance);
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            studentDtos.add(studentMapper.fromStudentToStudentDto(student));
        }
        return studentDtos;
    }

    @Override
    public List<StudentDto> getStudentsByNameAndEmailAndDateDeNaissance(String name, String email, String dateDeNaissance) {
        List<Student> students = studentRepository.findByNameAndEmailAndDateDeNaissance(name, email, dateDeNaissance);
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            studentDtos.add(studentMapper.fromStudentToStudentDto(student));
        }
        return studentDtos;
    }

    @Override
    public List<StudentDto> saveStudents(List<StudentDto> studentDtos) {
        // Convert DTOs to entities
        List<Student> students = new ArrayList<>();
        for (StudentDto studentDto : studentDtos) {
            students.add(studentMapper.fromStudentDtoToStudent(studentDto));
        }

        // Save all students
        students = studentRepository.saveAll(students);

        // Convert entities back to DTOs and return
        List<StudentDto> savedStudentDtos = new ArrayList<>();
        for (Student student : students) {
            savedStudentDtos.add(studentMapper.fromStudentToStudentDto(student));
        }
        return savedStudentDtos;
    }
}
