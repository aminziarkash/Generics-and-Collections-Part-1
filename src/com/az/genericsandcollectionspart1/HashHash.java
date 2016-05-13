package com.az.genericsandcollectionspart1;

/**
 * Created by aziarkash on 10-5-2016.
 */
public class HashHash {

    public int x;

    HashHash(int x) {
        this.x = x;
    }

    public static void main(String[] args) {

        HashHash hashHash = new HashHash(8);
        HashHash hashHash1 = new HashHash(3);
        String amin = "amin";
        String amin2 = "nima";
        int i = amin.hashCode();
        int j = amin2.hashCode();

        System.out.println("2 objects of same type containing same data...");
        System.out.println("First objects hashcode\t:\t" + hashHash.hashCode());
        System.out.println("Second objects hashcode\t:\t" + hashHash1.hashCode());

//        int i = 0;
//        int[] array = new int[100000];
//        for (; i < array.length; i++) {
//            array[i] = i + 1;
//        }
//            for (i = 0; i < array.length; i++) {
//                if (array[i] == 99999) {
//                    System.out.println("Value found @ " + i);
//                    break;
//                } else {
//                    System.out.println("Value not found @ =====> " + i);
//                }
//            }

        //        Integer x = new Integer(3);
        //        Integer y = new Integer(3);
        //
        //        System.out.println(x);
        //        System.out.println(y);
        //
        //        if (x.equals(y)) {
        //            System.out.println("They are equal.");
        //        }
    }

    @Override
    public boolean equals(final Object obj) {
        HashHash h = (HashHash) obj;

        if (h.x == this.x) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (x * 17);
    }

}
