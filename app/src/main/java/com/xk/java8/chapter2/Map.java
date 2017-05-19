package com.xk.java8.chapter2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by xuekai on 2017/5/18.
 */

public class Map {
    public static void main(String[] args) throws IOException {
        ArrayList<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple(1, 6, "red"));
        appleList.add(new Apple(2, 5, "blue"));
        appleList.add(new Apple(3, 4, "green"));
        appleList.add(new Apple(4, 3, "red"));
        appleList.add(new Apple(5, 2, "blue"));
        appleList.add(new Apple(6, 1, "red"));
        appleList.add(new Apple(6, 1, "red"));
        appleList.add(new Apple(6, 1, "red"));
        appleList.add(new Apple(6, 1, "red"));
        appleList.add(new Apple(6, 1, "red"));

        Predicate<Apple> isRed = (Apple::isRed);
        isRed=isRed.or(Apple::isBlue);


        List<Apple> collect = appleList.stream()
                .filter(isRed)
                .collect(Collectors.toList());

        for (Apple apple : collect) {
            System.out.println(apple);
        }
//
//        List<Integer> integers = Arrays.asList(1, 3, 5, 6, 8);
//
//
//        integers.sort(comparing(Integer::intValue).reversed());
//
//
//        for (Integer integer : integers) {
//            System.out.println(integer);
//        }


//        List<Apple> map1 = map(integers, Apple::new);
//        for (Apple apple : map1) {
//            System.out.println(apple);
//        }
//
//        System.out.println("-----------------");
//
//        List<Integer> integers1 = Arrays.asList(1, 3, 5, 6, 8);
//        List<Apple> bimap = bimap(integers1, integers1, Apple::new);
//        for (Apple apple : bimap) {
//            System.out.println(apple);
//        }
//
//        appleList.sort(Comparator.comparing(apple -> apple.getColor()));
//        //将苹果的集合转换成颜色的集合
//        List<String> map = map(appleList, Apple::getColor);
//        for (String s : map) {
//            System.out.println(s);
//        }
    }


    public static <T, R> List<R> map(List<T> appleList, Function<T, R> fun) throws IOException {
        List<R> rList = new ArrayList<R>();
        for (T t : appleList) {
            R apply = fun.apply(t);
            rList.add(apply);
        }
        return rList;
    }

    public static <T, U, R> List<R> bimap(List<T> t1, List<U> u1, BiFunction<T, U, R> fun) throws IOException {
        List<R> rList = new ArrayList<R>();
        for (T t : t1) {
            R apply = fun.apply(t, (U) t);
            rList.add(apply);
        }
        return rList;
    }


    static class Apple {
        Integer id;
        Integer weight;
        String color;

        public Apple(Integer id) {
            weight = id;
        }


        public String getColor() {
            return color;
        }

        public boolean isRed() {
            return "red".equals(color);
        }public boolean isBlue() {
            return "blue".equals(color);
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
