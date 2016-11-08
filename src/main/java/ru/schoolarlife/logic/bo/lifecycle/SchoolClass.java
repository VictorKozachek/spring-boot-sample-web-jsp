package ru.schoolarlife.logic.bo.lifecycle;

import ru.schoolarlife.logic.bo.person.Student;
import ru.schoolarlife.logic.bo.person.Teacher;

import java.util.Set;

/**
 * Created by victor on 08.11.16.
 */
public class SchoolClass {
    private long id;
    private String name;
    private Teacher curator;
    private Set<Student> students;
    private Set<Subject> subjects;

    public SchoolClass() {
    }

    public SchoolClass(long id, String name, Teacher curator) {
        this.id = id;
        this.name = name;
        this.curator = curator;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getCurator() {
        return curator;
    }

    public void setCurator(Teacher curator) {
        this.curator = curator;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}
