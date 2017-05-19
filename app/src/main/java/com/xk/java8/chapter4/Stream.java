package com.xk.java8.chapter4;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xuekai on 2017/5/19.
 */

public class Stream {
    public static void main(String[] args){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        java.util.stream.Stream<Integer> stream = integers.stream();
        stream.forEach(System.out::print);
        stream = integers.stream();

        stream.forEach(System.out::print);
    }
}
