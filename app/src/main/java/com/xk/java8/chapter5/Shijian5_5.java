package com.xk.java8.chapter5;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xuekai on 2017/5/22.
 */

public class Shijian5_5 {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


//        transactions.stream()
//                .filter(transaction -> transaction.getYear()==2011)
//                .sorted(Comparator.comparing(Transaction::getValue))
//                .forEach(transaction -> System.out.println(transaction));


//        transactions.stream()
//                .map(transaction -> transaction.getTrader().getCity())
//                .distinct()
//                .forEach(System.out::println);


//        transactions.stream()
//                .map(transaction -> transaction.getTrader())
//                .distinct()
//                .filter(trader -> trader.getCity().equals("Cambridge"))
//                .sorted(Comparator.comparing(Trader::getName))
//                .forEach(transaction -> System.out.println(transaction));

//        transactions.stream()
//                .map(transaction -> transaction.getTrader().getName())
//                .distinct()
//                .sorted()
//                .reduce((s1,s2)->s1+s2)//这样拼接字符串不高效，因为会一直创建新的String，可以用join替代，内部用的Stringbuilder
//                .ifPresent(System.out::println);
////                .collect(joining());System.out.println(collect);

//        boolean milan = transactions.stream()
//                .map(transaction -> transaction.getTrader())
//                .distinct()
//                .anyMatch(trader -> trader.getCity().equals("Milan"));
//        System.out.println(milan);


//         transactions.stream()
//                 .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
//                 .map(transaction -> transaction.getValue())
//                 .forEach(System.out::println);


//        transactions.stream()
//                .map(transaction -> transaction.getValue())
//                .reduce(Integer::max)
//                .ifPresent(System.out::println);

//        transactions.stream()
//                .min(Comparator.comparing(Transaction::getValue))
//                .ifPresent(System.out::println);




//        //数值流,通过mapToxxx将流特化成int、float等流
//        transactions.stream()
//                .mapToInt(transaction -> transaction.getValue())
//                .average()
//                .ifPresent(System.out::print);


        /**
         * 特化流转换成普通流
         */
        //        transactions.stream()
        //                .mapToInt(transaction -> transaction.getValue())
        //                .boxed()
        //                .forEach(System.out::println);
        //
        //
        //        int i = transactions.stream()
        //                .mapToInt(transaction -> transaction.getValue())
        //                .max()
        //                .orElse(1);
        //        System.out.println(i);
    }
}
