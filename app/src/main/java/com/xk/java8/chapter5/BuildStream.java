package com.xk.java8.chapter5;

import java.util.Random;
import java.util.stream.Stream;

/**
 * 创建流的方法
 * Created by xuekai on 2017/5/23.
 */

public class BuildStream {
    public static void main(String[] args) {

//        //由值创建流
//        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
//        //创建一个空流
//        Stream<Object> empty = Stream.empty();
//        //由数组创建一个流
//        IntStream stream = Arrays.stream(new int[]{1, 2, 3, 4});
//        //由文件生成一个流
//        try (Stream<String> lines = Files.lines(Paths.get("D://123.txt"), Charset.defaultCharset())) {
//            lines.flatMap(new Function<String, Stream<String>>() {
//                @Override
//                public Stream<String> apply(String s) {
//                    Stream<String> stream1 = Arrays.stream(s.split(""));
//                    return stream1;
//                }
//            })
//                    .filter(s -> (!s.equals(" ")))
//                    .distinct()
//                    .forEach(System.out::println);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //创建无限流
        //1.使用Iterate
//        Stream.iterate(2, integer -> integer +1)
//                .limit(10)
//                .forEach(System.out::println);

        //事例
//        Stream.iterate(new int[]{0,1},ints -> new int[]{ints[1],ints[0]+ints[1]})
//                .limit(10)
//                .forEach(ints -> System.out.println(ints[0]+" "+ints[1]));
        //2.使用generate
        Random random = new Random();
        Stream.generate(random::nextInt)
                .limit(10)
                .forEach(System.out::println);
    }
}
