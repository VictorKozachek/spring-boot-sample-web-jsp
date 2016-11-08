package ru.schoolarlife.logic.bo.person;

import ru.schoolarlife.logic.bo.location.Address;
import ru.schoolarlife.logic.helpers.Gender;

import java.util.Date;

/**
 * Created by victor on 01.11.16.
 */
public abstract class Person {
    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected Gender gender;
    protected Date birthDate;
    protected int age;
    protected Address address;
    protected String phone;


}
