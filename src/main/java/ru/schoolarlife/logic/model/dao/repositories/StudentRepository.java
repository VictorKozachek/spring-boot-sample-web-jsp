package ru.schoolarlife.logic.model.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.schoolarlife.logic.bo.person.Student;

/**
 * Created by victor on 11.11.16.
 */
public interface StudentRepository   extends JpaRepository<Student, Long> {
    Student findByFirstName(String firstName);
}
