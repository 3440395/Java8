package com.xk.java8.chapter4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by xuekai on 2017/5/18.
 */

public class FlatMap {
    public static void main(String[] args) throws IOException {
//        List<String> words = Arrays.asList("hello", "word", "nicetomeetyou", "howareyou");
//
//        words.stream()
//                .map(s -> s.split(""))//把字符串映射成数组
//                .flatMap(Arrays::stream)//把数组faltmap成字符的流
//                .distinct()
//                .forEach(System.out::println);


        ceyan5_2();
//                .flatMap()

    }

    /**
     * 测验5.2
     */
    private static void ceyan5_2() {
        List<Integer> ints1 = new ArrayList<>();
        Random random = new Random(10);
        for (int i = 0; i < 1000; i++) {
            ints1.add(random.nextInt(10000));
        }
        int target = 100;
        long start = System.currentTimeMillis();
        ints1.parallelStream()
                .flatMap(integer -> ints1.parallelStream()
                        .sorted()
                        .filter(integer1 -> integer < integer1)
                        .map(integer1 -> {
                                    Integer[] integers = new Integer[2];
                                    integers[0] = integer;
                                    integers[1] = integer1;
                                    return integers;
                                }
                        )
                )
                .filter(integers -> integers[0] + integers[1] == target)
                .forEach(integers -> {
                            System.out.println(integers[0] + "-" + integers[1]);
                            System.out.println(System.currentTimeMillis() - start);
                        }
                );
    }


}
