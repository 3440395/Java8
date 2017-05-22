package com.xk.java8.chapter5;

import java.util.ArrayList;

/**
 * Created by xuekai on 2017/5/22.
 */

public class FindAndMatch {
    public static void main(String[] args) {
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


//        boolean b = appleList.stream()
//                .allMatch(apple -> apple instanceof Apple);
//        System.out.println(b);

//        appleList.stream()
//                .findAny()
//                .ifPresent(System.out::print);



//        System.out.println(appleList.stream()
//                .reduce(new Apple(0, 0, "ooo"), new BinaryOperator<Apple>() {
//                    @Override
//                    public Apple apply(Apple apple, Apple apple2) {
//                        return new Apple(0, 0, apple.getColor() + apple2.color);
//                    }
//                }).color);







//        List<Integer> integers= Arrays.asList(1, 3, 5, 7, 9);
//        integers.stream()
//                .reduce(Integer::max)
//                .ifPresent(System.out::print);



        Integer reduce = appleList.stream()
                .map(apple -> 1)
                .reduce(0, Integer::sum);
        System.out.println(reduce);
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
        }

        public boolean isBlue() {
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
