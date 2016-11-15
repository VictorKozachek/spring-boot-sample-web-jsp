package ru.schoolarlife.logic.bo.signup;

import ru.schoolarlife.logic.bo.person.Person;

/**
 * @author val.rudi
 */
public class Signup {
    private Person person;

    public Signup() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}