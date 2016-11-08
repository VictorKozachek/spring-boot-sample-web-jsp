package ru.schoolarlife.logic.bo.schedule;

import java.util.Date;
import java.util.Set;

/**
 * Created by victor on 08.11.16.
 */
public class Day {
    private long id;
    private String name;
    private Date date;
    private Set<Lesson> lessons;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}
