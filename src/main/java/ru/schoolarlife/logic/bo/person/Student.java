package ru.schoolarlife.logic.bo.person;

import ru.schoolarlife.logic.bo.lifecycle.SchoolClass;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by victor on 08.11.16.
 */
@SuppressWarnings("PMD")
@Entity
@Table(name = "student")
public class Student extends Person {

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_id")
    private SchoolClass schoolClass;

    @ManyToMany
    @JoinTable(name = "parent_student", joinColumns = @JoinColumn(name = "parent_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Parent> parents;

}
