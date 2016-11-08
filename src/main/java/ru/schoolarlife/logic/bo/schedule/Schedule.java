package ru.schoolarlife.logic.bo.schedule;

import ru.schoolarlife.logic.bo.school.School;

import java.util.Set;

/**
 * Created by victor on 08.11.16.
 */
public class Schedule {
    private long id;
    private int year;
    private int quarter;
    private School school;
    private Set<Week> weeks;
}
