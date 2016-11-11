package ru.schoolarlife.logic.bl.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.schoolarlife.logic.bl.students.interfaces.StudentService;
import ru.schoolarlife.logic.bo.person.Student;
import ru.schoolarlife.logic.model.dao.repositories.StudentRepository;

/**
 * Created by victor on 11.11.16.
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }
}
