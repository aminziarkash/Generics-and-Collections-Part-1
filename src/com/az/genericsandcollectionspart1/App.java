package com.az.genericsandcollectionspart1;

import java.util.*;

/**
 * Created by aziarkash on 26-4-2016.
 */
public class App {

    private final String firstName = "Amin";

    private final String lastName = "Ziarkash";

    private final int age = 27;

    private String objectiveString;

    public static void main(String[] args) {

        App application = new App();

        application.overridingToStringExample();

        application.overridingEqualsExample();

        application.overridingHashCodeExample();

        application.arrayListBasicsExample();

        application.autoboxingWithCollectionsExample();

        application.sortingCollectionsExample();

        application.compareAbleInterfaceExample();

        application.searchingArraysAndCollectionsExample();

        application.convertingArraysToListsToArraysExample(); // add separator

        application.listsToArrayMethodExample();

        application.usingListsAndIterator();

        application.usingSetsExample();

        application.usingMapsExample(); // change title

    }

    private void usingMapsExample() {
        objectiveString = "Using Sets";
        System.out.println(objectiveString);
        addSub(objectiveString);

        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("k1", new Dog("aiko"));   // add some key/value pairs
        map.put("k2", Pets.DOG);
        map.put(Pets.CAT, "CAT key");

        Dog d1 = new Dog("clover");     // changed at the end of the method
        map.put(d1, "Dog key");
        map.put(new Cat(), "Cat key");
        System.out.println("Get Dog with 'k1' as key\t\t\t:\t" + map.get("k1"));

        String k2 = "k2";
        System.out.println("Get Dog with 'k2' as key\t\t\t:\t" + map.get(k2)); // from the enum

        Pets p = Pets.CAT;
        System.out.println("Get Cat with enum as key\t\t\t:\t" + map.get(p));
        System.out.println("Get Dog with Dog object as the key\t:\t" + map.get(d1));
        System.out.println("Get Cat with Cat object as the key\t:\t" + map.get(new Cat()));
        System.out.println("Size of the map\t:\t" + map.size());

        d1.name = "magnolia"; // changed the name so the hashcode changed
        System.out.println("Get Dog 'clover' after changing its name\t:\t" + map.get(d1)); // cannot find it because hashcode changed

        addSeparator();
    }

    private void usingSetsExample() {
        objectiveString = "Using Sets";
        System.out.println(objectiveString);
        addSub(objectiveString);

        boolean[] ba = new boolean[5];

        // Set s = new TreeSet(); // Cannot be used in this example because the objects are not mutually comparable
        Set s = new HashSet(); // Do not guarantee any ordering
        System.out.println("Add 5 values to the HashSet");
        ba[0] = s.add("a");
        ba[1] = s.add(new Integer(42));
        ba[2] = s.add("b");
        ba[3] = s.add("a"); // will fail because 'a' is already in the set
        ba[4] = s.add(new Object());

        System.out.print("Value addition status\t\t\t:\t");
        for(int i = 0; i < ba.length; i++){
            System.out.print(ba[i] + " ");
        }
        System.out.println();

        System.out.print("Actual values in the HashSet\t:\t");
        for(Object o : s) {
            System.out.print(o + " ");
        }

        addSeparator();
    }

    private void usingListsAndIterator() {
        objectiveString = "Using Lists and an Iterator";
        System.out.println(objectiveString);
        addSub(objectiveString);

        List<Employee> employeeList = new ArrayList<Employee>();
        Employee employee = new Employee("Amin", "Ziarkash", 100);
        employeeList.add(employee);
        employeeList.add(new Employee("Varun", "Aggarwal", 44));
        employeeList.add(new Employee("Xiaochen", "Zhang", 66));

        Iterator<Employee> iterator = employeeList.iterator(); // make the iterator
        System.out.println("Iterate through employees");
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            System.out.println("Found employee\t:\t" + emp.firstName);
        }

        System.out.println("List Size\t\t:\t" + employeeList.size());
        System.out.println("Last Employee\t:\t" + employeeList.get(2).firstName);
        System.out.println("\nRemove second employee from the list");
        employeeList.remove(2);

        Object[] objects = employeeList.toArray();
        System.out.println("Loop the array again");
        for (Object o : objects) {
            Employee emplObject = (Employee) o;
            System.out.println("Employee\t:\t" + emplObject.firstName);
        }

        addSeparator();
    }

    private void listsToArrayMethodExample() {
        objectiveString = "Using Lists toArray() method";
        System.out.println(objectiveString);
        addSub(objectiveString);

        List<Integer> integerList = new ArrayList<Integer>();
        for(int x=0; x<3; x++) {
            integerList.add(x);
        }
        Object[] objectArray = integerList.toArray();          // create an Object array
        Integer[] integerArray = new Integer[3];
        integerArray = integerList.toArray(integerArray);       // create an Integer array

        System.out.print("Values in the array\t:\t");
        for (Integer i : integerArray) {
            System.out.print(i + " ");
        }

        addSeparator();
    }

    private void convertingArraysToListsToArraysExample() {
        objectiveString = "Converting Arrays to Lists to Arrays";
        System.out.println(objectiveString);
        addSub(objectiveString);

        String[] sa = {"one", "two", "three", "four"};
        System.out.println("Array size\t\t:\t" + sa.length);
        System.out.print("Array values\t:\t");
        for (String s : sa) {
            System.out.print(s + " ");
        }
        System.out.println("\n\nConverting array to List using Arrays.asList(array)...");
        List sList = Arrays.asList(sa);
        System.out.println("List size\t\t:\t" + sList.size());
        System.out.println("List idx2\t\t:\t" + sList.get(2));

        System.out.println("\nSet 'six' at third index of the List...");
        sList.set(3, "six");
        System.out.println("Get idx3 from List\t\t:\t" + sList.get(3));
        System.out.println("\nPut 'five' in array[1] index");
        sa[1] = "five";
        System.out.println("List[1]\t\t\t\t:\t" + sList.get(1));

        System.out.print("After modifications\t:\t");
        for (Object object : sList.toArray()) {
            System.out.print(object + " ");
        }

        System.out.println("\nDemo the Test app using Arrays.asList() method to speed up the search process\n");
        addSeparator();
    }

    static class ResortComparator implements Comparator<String> { // define the Comparator

        @Override
        public int compare(final String a, final String b) { // By switching the use of the arguments in the invocation of compareTo(), we get an inverted sort.
            return b.compareTo(a);
        }
    }

    private void searchingArraysAndCollectionsExample() {
        objectiveString = "Searching Arrays and Collections";
        System.out.println(objectiveString);
        addSub(objectiveString);

        String[] sa = {"one", "two", "three", "four"};
        Arrays.sort(sa); // Sort the  sa  array, alphabetically (the natural order).
        System.out.print("array values (natural order)\t:\t");
        for (String s : sa) {
            System.out.print(s + " ");
        }
        System.out.println("\nbinarySearch 'one' index\t\t:\t" + Arrays.binarySearch(sa, "one")); // Search for the location of element  "one" , which is 1.

        ResortComparator rs = new ResortComparator(); // Make a  Comparator  instance. On the next line, we re-sort the array using the  Comparator .
        Arrays.sort(sa, rs);
        System.out.print("values in reversed sorting\t\t:\t");
        for (String s : sa) {
            System.out.print(s + " ");
        }
        System.out.println("\n\nbinarySearch for 'one' without passing the comparator\t:\t" + Arrays.binarySearch(sa, "one")); // Attempt to search the array. We didn't pass the  binarySearch() method the Comparator we used to sort the array, so we got an incorrect (undefined) answer.
        System.out.println("pass the comparator and binarySearch again\t\t\t\t:\t" +  Arrays.binarySearch(sa, "one", rs)); // Search again, passing the  Comparator  to  binarySearch() . This time, we get the correct answer, 2.
    }

    private void compareAbleInterfaceExample() {
        objectiveString = "The Comparable Interface";
        System.out.println(objectiveString);
        addSub(objectiveString);

        Organization organization1 = new Organization("Qualogy");
        Organization organization2 = new Organization("Google");
        Organization organization3 = new Organization("Microsoft");
        Organization organization4 = new Organization("Yahoo");
        Organization organization5 = new Organization("Xelion");

        List<Organization> organizationList = new ArrayList<>();
        organizationList.add(organization1);
        organizationList.add(organization2);
        organizationList.add(organization3);
        organizationList.add(organization4);
        organizationList.add(organization5);

        System.out.println("Organization list BEFORE sorting\t:\t" + organizationList);
        Collections.sort(organizationList);
        System.out.println("Organization list AFTER sorting\t\t:\t" + organizationList);

        addSeparator();
    }

    private void sortingCollectionsExample() {
        objectiveString = "Sorting Collections";
        System.out.println(objectiveString);
        addSub(objectiveString);

        ArrayList<String> list = new ArrayList<String>();
        list.add("Amin");
        list.add("Ziarkash");
        list.add("Varun");
        list.add("Aggarwal");
        list.add("Quasar");
        list.add("Qualogy");
        list.add("Solution");
        System.out.println("List, UNSORTED\t:\t" + list);
        Collections.sort(list);
        System.out.println("List, SORTED\t:\t" + list);

        addSeparator();
    }

    private void autoboxingWithCollectionsExample() {
        objectiveString = "Autoboxing with Collections";
        System.out.println(objectiveString);
        addSub(objectiveString);

        // PRE JAVA 5 CODE
        Integer y = new Integer(567);    // make it
        int x = y.intValue();            // unwrap it
        x++;                             // use it
        y = new Integer(x);              // rewrap it
        System.out.println("Pre java 5 way\t:\ty = " + y);  // print it

        // POST JAVA 5 CODE
        Integer yy = new Integer(567);    // make it
        yy++;                             // unwrap it, increment it, rewrap it
        System.out.println("Post java 5 way\t:\ty = " + yy);  // print it

        boxingAndEquals();

        addSeparator();
    }

    private void boxingAndEquals() {
        Integer i1 = 1000;
        Integer i2 = 1000;
        System.out.println("\ni1\t:\t" + i1);
        System.out.println("i2\t:\t" + i2);
        System.out.println("\nchecking if i1 and i2 are the same objects using\t:\ti1 != i2");
        if (i1 != i2) {
            System.out.println("they are different objects");
        }

        System.out.println("\nchecking if i1 and i2 are meaningfully equal using\t:\ti1.equals(i2)");
        if (i1.equals(i2)) {
            System.out.println("they are meaningfully equal");
        }

        Integer i3 = 10;
        Integer i4 = 10;
        System.out.println("\ni3\t:\t" + i3);
        System.out.println("i4\t:\t" + i4);
        System.out.println("\nchecking if i3 and i4 are the same objects using\t:\ti3 == i4");

        //
        // In order to save memory, the following wrapper objects will always
        // be '==' when their primitive values are the same:
        //
        // Boolean, Byte, Character, Short and Integer

        if (i3 == i4) {
            System.out.println("same object");
        }

        System.out.println("\nchecking if i3 and i4 are meaningfully equal using\t:\ti3.equals(i4)");
        if (i3.equals(i4)) {
            System.out.println("they are meaningfully equal");
        }
    }

    private void arrayListBasicsExample() {
        objectiveString = "ArrayList basics";
        System.out.println(objectiveString);
        addSub(objectiveString);

        List<String> myList = new ArrayList<String>();
        String s = "quasar";
        myList.add("hello"); // autoboxing
        myList.add(s);
        myList.add(s+s);

        System.out.println("ArrayList data\t\t\t\t\t:\t" + myList);
        System.out.println("List size\t\t\t\t\t\t:\t" + myList.size());
        System.out.println("List contains 42\t\t\t\t:\t" + myList.contains(42));
        System.out.println("List contains quasar\t\t\t:\t" + myList.contains("quasar"));
        myList.remove("quasar");
        System.out.println("Size after removing 'quasar'\t:\t" + myList.size());
        System.out.println("ArrayList data\t\t\t\t\t:\t" + myList);

        addSeparator();
    }

    private void overridingHashCodeExample() {
        objectiveString = "Overriding the hashCode() method";
        System.out.println(objectiveString);
        addSub(objectiveString);

        Employee employee1 = new Employee("Amin", "Ziarkash", 27);
        Employee employee2 = new Employee("Amin", "Amin", 28);

        System.out.println("EMPLOYEE 1:");
        System.out.println("First name\t:\t" + employee1.firstName);
        System.out.println("Last name\t:\t" + employee1.lastName);
        System.out.println("Age\t\t\t:\t" + employee1.age + "\n");

        System.out.println("EMPLOYEE 2:");
        System.out.println("First name\t:\t" + employee2.firstName);
        System.out.println("Last name\t:\t" + employee2.lastName);
        System.out.println("Age\t\t\t:\t" + employee2.age + "\n");

        System.out.println("hashCode for Employee1\t:\t" + employee1.hashCode());
        System.out.println("hashCode for Employee2\t:\t" + employee2.hashCode());

        addSeparator();
    }

    private void overridingToStringExample() {
        addSeparator();
        objectiveString = "Overriding the toString() method";
        System.out.println(objectiveString);
        addSub(objectiveString);

        App app = new App();
        String appString = app.toString();
        System.out.println("Using the toString() method without overriding it\t:\t" + appString);

        Employee employee = new Employee(firstName, lastName, age);
        String aminString = employee.toString();
        System.out.println("Using the overridden toString() method \t\t\t\t:\t" + aminString);

        addSeparator();
    }

    private void overridingEqualsExample() {
        objectiveString = "Overriding the equals() method";
        System.out.println(objectiveString);
        addSub(objectiveString);

        Employee employee = new Employee(firstName,lastName,age);
        Employee employee1 = new Employee(firstName, "Varun", 3000);

        System.out.println("PERSON 1:");
        System.out.println("First name\t:\t" + employee.firstName);
        System.out.println("Last name\t:\t" + employee.lastName);
        System.out.println("Age\t\t\t:\t" + employee.age + "\n");

        System.out.println("PERSON 2:");
        System.out.println("First name\t:\t" + employee1.firstName);
        System.out.println("Last name\t:\t" + employee1.lastName);
        System.out.println("Age\t\t\t:\t" + employee1.age + "\n");


        if (employee.equals(employee1)) {
            System.out.println("They are equal!");
        }
        addSeparator();
    }

    private void addSub(String objectiveString) {
        for (int i = 0; i < objectiveString.length(); i++) {
            System.out.print("-");
        }
        System.out.println("\n");
    }

    private void addSeparator() {
        System.out.println("\n**************************************************************************************************************");
    }
}


class Boxing {
    static Integer x;

    public static void main(String [] args) {
        doStuff(x); // NullPointerException because x has no value to un-box
    }

    static void doStuff(int z) {
        int z2 = 5;
        System.out.println(z2 + z);
    }
}
