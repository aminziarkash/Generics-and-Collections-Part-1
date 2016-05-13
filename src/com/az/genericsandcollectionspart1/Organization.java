package com.az.genericsandcollectionspart1;

/**
 * Created by aziarkash on 12-5-2016.
 */
public class Organization implements Comparable<Organization> { // To compare to Organization

    String name;

    public Organization(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(final Organization o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
