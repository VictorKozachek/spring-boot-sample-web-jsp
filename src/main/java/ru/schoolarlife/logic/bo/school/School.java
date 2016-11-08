package ru.schoolarlife.logic.bo.school;

import ru.schoolarlife.logic.bo.person.Teacher;

import java.util.Set;

/**
 * Created by victor on 08.11.16.
 */
public class School {
    private long id;
    private String name;
    private Teacher principal;
    private Set<SchoolBuilding> schoolBuildings;

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

    public Teacher getPrincipal() {
        return principal;
    }

    public void setPrincipal(Teacher principal) {
        this.principal = principal;
    }

    public Set<SchoolBuilding> getSchoolBuildings() {
        return schoolBuildings;
    }

    public void setSchoolBuildings(Set<SchoolBuilding> schoolBuildings) {
        this.schoolBuildings = schoolBuildings;
    }
}
