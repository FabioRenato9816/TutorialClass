package pt.iade.unimanage.models;

import java.time.LocalDate;

public abstract class Person {
    protected String name;
    protected LocalDate birthDay;
    protected String email;
    protected char gender;

    public Person (String name, LocalDate birthDay, char gender) {
        this.name = name;
        this.birthDay = birthDay;
        this.email = "";
        this.gender = gender;
    }

 

    public abstract String getReference();
    
    public abstract String getName();

    public abstract String getEmail();

    public abstract String toString();

}