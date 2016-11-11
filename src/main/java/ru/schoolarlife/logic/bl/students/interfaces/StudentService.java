package ru.schoolarlife.logic.bl.students.interfaces;


import ru.schoolarlife.logic.bo.person.Student;

/**
 * Created by victor on 11.11.16.
 */
public interface StudentService {
    public Student save(Student student);

    public Student findByFirstName(String firstName);
}
