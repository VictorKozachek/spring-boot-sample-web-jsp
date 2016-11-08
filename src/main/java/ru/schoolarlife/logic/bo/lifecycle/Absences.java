package ru.schoolarlife.logic.bo.lifecycle;

import ru.schoolarlife.logic.bo.person.Student;
import ru.schoolarlife.logic.bo.person.Teacher;
import ru.schoolarlife.logic.bo.schedule.Lesson;

import java.time.LocalDateTime;

/**
 * Created by victor on 08.11.16.
 */
public class Absences {
    private long id;
    private Subject subject;
    private Student student;
    private Teacher teacher;
    private Lesson lesson;
    private String reason;

    public Absences() {
    }

    public Absences(long id, Subject subject, Student student, Teacher teacher, Lesson lesson, String reason) {
        this.id = id;
        this.subject = subject;
        this.student = student;
        this.teacher = teacher;
        this.lesson = lesson;
        this.reason = reason;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
