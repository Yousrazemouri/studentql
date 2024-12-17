package org.example.studentql.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.studentql.dao.entity.Student;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Find students by name
    List<Student> findByName(String name);

    // Find students by email
    List<Student> findByEmail(String email);

    // Find students by date_de_naissance
    List<Student> findByDateDeNaissance(String dateDeNaissance);

    // Find students by name, email, and date_de_naissance
    List<Student> findByNameAndEmailAndDateDeNaissance(String name, String email, String dateDeNaissance);
}
