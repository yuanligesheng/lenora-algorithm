package com.example.algorithm.kexin2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerArray;


/**
 * @Author Wang Haoyu
 * @Date 2024/12/29 18:41
 * @Version 1.0
 */
public class test {

    private static int[] value = new int[]{1,2,3};
    private static AtomicIntegerArray integerArray = new AtomicIntegerArray(value);

    class Emaill {
        public String address;

        public Emaill(String address) {
            this.address = address;
        }
        public int hashcode() {
            return address.hashCode();
        }
    }

    public static void main(String[] args) {

       Object[] objects = new String[10];

       //String[] str = new Object[10];

        Object[] arr = new Object[0];




        int result = integerArray.getAndAdd(1,5);
        System.out.println();




        Map<Key, String> map = new HashMap<>();
        Key key = new Key(10,20);
        map.put(key, "ro");
        System.out.println(map.get(key));

        key.setFst(10);
        System.out.println(map.get(key));

        key.setFst(30);
        System.out.println(map.get(key));


        Integer value1 = 100;
        Integer value2 = 100;
        Integer value3 = 150;
        Integer value4 = 150;
        //System.out.println(value1 == value2);
        //System.out.println(value3 == value4);
        System.out.println(value3 == 150);




        int fst  =5 ;
        int snd = 2;
        while (snd < fst--) {
            snd++;
        }
        System.out.println(snd);

        int nr = 5;
        do {
            System.out.println(nr);
        } while (--nr > 5);
        System.out.println("fi");


        BigDecimal income= new BigDecimal("1.03");
        BigDecimal expense = new BigDecimal("0.42");
        System.out.println(income.subtract(expense));
    }

    @Data
    @AllArgsConstructor
    public static class Key {
        private int fst;
        private int snd;
    }
}
