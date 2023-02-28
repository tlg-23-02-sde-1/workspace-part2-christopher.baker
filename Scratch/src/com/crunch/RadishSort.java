package com.crunch;

import java.util.ArrayList;
import java.util.List;

class RadishSort {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        radishes.add(new Radish("red", 1.1, 2.1, 0));
        radishes.add(new Radish("pink", 3.5, 0.0 , 3));
        radishes.add(new Radish("black", 2.2, 4.2, 0));
        radishes.add(new Radish("white", 1.8, 0.6, 7));

        System.out.println("Original List");
        dump(radishes);
        System.out.println();

        System.out.println("Sort by natural order (size)");
        radishes.sort(null);
        dump(radishes);
        System.out.println();

        System.out.println("Sort by color, via Comparator");
        radishes.sort(new RadishColorComparator());
        dump(radishes);
        System.out.println();

    }

    private static void dump(List<Radish> radishList){
        for (Radish radish : radishList){
            System.out.println(radish);
        }
    }

//fields
//constructor
//business method
//helper method
//accessor method get/set/toString
}