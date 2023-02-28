package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;

class TelevisionClient {
    public static void main(String[] args) {
//        Television tv1 = new Television();
//        Television tv2 = new Television( "RCA", 10);
//        System.out.println(tv1);
//        System.out.println(tv2);
//
//        tv2.changeChannel(6);
//        System.out.println(tv2);

        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("LG", 52);
        System.out.println("tva == tvb:" + (tvA == tvB));
        System.out.println("tvA.equals(tvB): " + tvA.equals(tvB));

        System.out.println(tvA.hashCode()); //54
        System.out.println(tvB.hashCode()); //54

        //Let's create a Set<Television> and see what happens
        Set<Television> tvs = new HashSet<>();
        tvs.add(tvA);
        tvs.add(tvB); // should be rejected as a "duplicate"

        //The size of the Set should be 1
        System.out.println("The size of the Set is: " + tvs.size());

    }
//fields
//constructor
//business method
//helper method
//accessor method get/set/toString
}