package com.az.genericsandcollectionspart1;

/**
 * Created by aziarkash on 13-5-2016.
 */
public class Dog {

    public String name;

    public Dog(String n) {
        name = n;
    }

    @Override
    public boolean equals(Object o) {
        if((o instanceof Dog) &&
                (((Dog)o).name == name)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return name.length();
    }

}
