package com.xk.java8.chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuekai on 2017/5/17.
 */

public class AppleFilter {
    private static List<Apple> result = new ArrayList<>();

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple(3, 4, "green"));
        appleList.add(new Apple(6, 1, "red"));
        appleList.add(new Apple(1, 6, "red"));
        appleList.add(new Apple(1, 6, "red"));
        appleList.add(new Apple(2, 5, "blue"));
        appleList.add(new Apple(4, 3, "red"));
        appleList.add(new Apple(5, 2, "blue"));
        appleList.add(new Apple(6, 1, "red"));
        appleList.add(new Apple(6, 1, "red"));
        appleList.add(new Apple(6, 1, "red"));
        appleList.add(new Apple(6, 1, "red"));

        long start = System.currentTimeMillis();
        appleList.stream()
                .skip(1)
                .filter(a -> {
                    System.out.println("filter" + a.getId());
                    return a.getColor().equals("red");
                })
                .map((apple) -> {
                    System.out.println("map" + apple.getId());
                    return apple.getId();
                })
                .sorted()
                .distinct()
                .limit(3)
                .forEach(System.out::println);
//        for (Integer s : collect) {
//            System.out.println("chuliwanle ---" + s);
//        }
//        System.out.println(System.currentTimeMillis() - start);
//        for (Apple so : collect) {
//            System.out.println(so);
//        }

//        long start1 = System.currentTimeMillis();
//        List<Apple> collect1 = appleList.parallelStream()
//                .filter(a -> a.getColor().equals("red"))
//                .collect(Collectors.toList());
//        System.out.println(System.currentTimeMillis() - start1);
//        for (Apple so : collect1) {
//            System.out.println(so);
//        }
//        filterByNormal(appleList);
//        filterByNormal1(appleList, apple -> apple.color.equals("red"));
//        filterByNormal1(appleList, Apple::isRed);
//        filterByJava8(appleList);

//        for (Apple apple : result) {
//            System.out.println(apple);
//        }
    }

    private static void filterByJava8(List<Apple> appleList) {
    }

    private static void filterByNormal(List<Apple> appleList) {
        for (Apple apple : appleList) {
            if (apple.color.equals("red")) {//当我要是想要使用别的条件筛选的时候，需要再写一个新的方法，全部copy，只是这行改变，太麻烦了，所以升级
                result.add(apple);
            }
        }
    }

    interface Tiaojian<T> {
        boolean test(T t);
    }

    private static void filterByNormal1(List<Apple> appleList, Tiaojian<Apple> tiaojian) {
        for (Apple apple : appleList) {
            if (tiaojian.test(apple)) {//当我要是想要使用别的条件筛选的时候，需要再写一个新的方法，全部copy，只是这行改变，太麻烦了，所以升级
                result.add(apple);
            }
        }
    }

    static class Apple {
        Integer id;
        Integer weight;
        String color;

        public String getColor() {
            return color;
        }

        public boolean isRed() {
            return "red".equals(color);
        }

        public Apple(Integer id, Integer weight, String color) {
            this.id = id;
            this.weight = weight;
            this.color = color;
        }

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

