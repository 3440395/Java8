package com.xk.java8.chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuekai on 2017/5/17.
 */

public class AppleSort {
    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple(1, 6));
        appleList.add(new Apple(2, 5));
        appleList.add(new Apple(3, 4));
        appleList.add(new Apple(4, 3));
        appleList.add(new Apple(5, 2));
        appleList.add(new Apple(6, 1));
        sortByNormal(appleList);
//        sortByJava8(appleList);

        for (Apple apple : appleList) {
            System.out.println(apple);
        }
    }

    private static void sortByJava8(List<Apple> appleList) {
        appleList.sort(Comparator.comparing(Apple::getId));
    }

    private static void sortByNormal(List<Apple> appleList) {
        Collections.sort(appleList, (a1, a2) -> a1.weight.compareTo(a2.weight));
    }
}

class Apple {
    Integer id;
    Integer weight;

    public Apple(Integer id, Integer weight) {
        this.id = id;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                ", weight=" + weight +
                '}';
    }
}