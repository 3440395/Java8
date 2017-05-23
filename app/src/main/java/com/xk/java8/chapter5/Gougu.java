package com.xk.java8.chapter5;

import java.util.stream.IntStream;

/**
 * Created by xuekai on 2017/5/23.
 */

public class Gougu {
    public static void main(String[] args) {
        int[] source = {};


        int a = 3;
//        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//        IntStream.range(0, 100)
//                .filter(i -> Math.sqrt(a * a + i * i) % 1 == 0)
//                .mapToObj(value -> new int[]{a, value, (int) Math.sqrt(a * a + value * value)})
//                .forEach(ints -> System.out.println(ints[0] + " " + ints[1] + " " + ints[2]));


        IntStream.range(1, 100)
                .boxed()
                .flatMap(integer -> IntStream.range(integer, 100)
                        .boxed()
                        .filter(i -> Math.sqrt(integer * integer + i * i) % 1 == 0)
                        .map(value -> new int[]{integer, value, (int) Math.sqrt(integer * integer + value * value)})
                )
                .limit(4)
                .forEach(ints -> System.out.println(ints[0] + " " + ints[1] + " " + ints[2]));

    }
}
