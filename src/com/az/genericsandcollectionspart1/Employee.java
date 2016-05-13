package com.az.genericsandcollectionspart1;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by aziarkash on 26-4-2016.
 */
public class Employee {

    String firstName;

    String lastName;

    int age;

    Employee(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Hi there, my name is " + firstName + " " + lastName + " and I am " + age + " old.";
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof Employee) && (((Employee) obj).firstName.equals(this.firstName))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 7 * firstName.hashCode();
    }
}
