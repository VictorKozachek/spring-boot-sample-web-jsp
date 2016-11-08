package ru.schoolarlife.logic.bo.schedule;

import ru.schoolarlife.logic.bo.lifecycle.Absences;
import ru.schoolarlife.logic.bo.lifecycle.Assessment;
import ru.schoolarlife.logic.bo.lifecycle.Subject;
import ru.schoolarlife.logic.bo.person.Teacher;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by victor on 08.11.16.
 */
public class Lesson {
    private long id;
    private int index;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Subject subject;
    private Teacher teacher;
    private Set<Assessment> assessments;
    private Set<Absences> absences;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(Set<Assessment> assessments) {
        this.assessments = assessments;
    }

    public Set<Absences> getAbsences() {
        return absences;
    }

    public void setAbsences(Set<Absences> absences) {
        this.absences = absences;
    }
}
