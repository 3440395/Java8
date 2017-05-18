package com.xk.java8.chapter1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

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
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple apple1, Apple apple2) {
                return apple1.getId().compareTo(apple2.getId());
            }
        });
    }

    private static void sortByNormal1(List<Apple> appleList) {
        appleList.sort((apple1, apple2) -> apple1.getId().compareTo(apple2.getId()));
    }

    /**
     * 通过Compator里的默认方法comparing,可以提取类中需要比较的东西
     */
    private static void sortByNormal2(List<Apple> appleList) {
        appleList.sort(Comparator.comparing(new Function<Apple, Integer>() {
            @Override
            public Integer apply(Apple apple) {
                return apple.getId();
            }
        }));
    }
    /**
     * 通过Compator里的默认方法comparing,可以提取类中需要比较的东西
     */
    private static void sortByNormal3(List<Apple> appleList) {
        appleList.sort(Comparator.comparing(apple -> apple.getId()));
    }

    /**
     * 通过Compator里的默认方法comparing,可以提取类中需要比较的东西
     */
    private static void sortByNormal4(List<Apple> appleList) {
        appleList.sort(Comparator.comparing(Apple::getId));
    }
    static class Apple {
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
}