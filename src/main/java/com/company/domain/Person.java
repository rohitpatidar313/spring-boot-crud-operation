package com.company.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message="First name can not be null.")
    private String firstName;
    @NotNull(message="Last name can not be null.")
    private String lastName;
    @Min(value=1,message="Minimum value should be more than 0.")
    @Max(value=120, message = "Age should not be more than 120.")
    private int age;
    private String favColor;
    private String hobby;

    public Person(){}
    public Person(String firstName, String lastName, int age, String favColor, String hobby) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.favColor = favColor;
        this.hobby=hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavColor() {
        return favColor;
    }

    public void setFavColor(String favColor) {
        this.favColor = favColor;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", favColor='" + favColor + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
