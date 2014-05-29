package com.yuramitsyuk.poker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Poker {
    public static void main(String[] args) {
        System.out.println("Input 5 cadrs (Separate spaces, any register): ");
        Scanner input=new Scanner(System.in);
        String str=input.nextLine().toLowerCase();
        String [] array=str.split(" ");
        Integer count=0;

        Integer [] array1=transform(array);

        List<Integer> list=Arrays.asList(array1);
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for (Integer i : list) {

            count = hashmap.get(i);
            hashmap.put(i, count == null ? 1 : count + 1);
        }
        for (Object key : hashmap.keySet().toArray()) {

            if (hashmap.get(key) == 1) {

                hashmap.remove(key);
            }
        }

        if (isStraight(array1)){
            System.out.println("Straight");
        }
        if (hashmap.size()==1&hashmap.values().contains(2)){
            System.out.println("One pair");
        }else{
            if (hashmap.size()==1&hashmap.values().contains(3)){
                System.out.println("Three of a kind");
            }else{
                if (hashmap.size()==1&hashmap.values().contains(4)){
                    System.out.println("Four of a kind");
                }
            }
        }
        if (hashmap.size()==2&hashmap.values().contains(3)){
            System.out.println("Full house");
        }else {
            if (hashmap.size()==2){
                System.out.println("Two pair");
            }
        }
        input.close();
    }
    public static Integer[] transform(String[] s){
        Integer [] array=new Integer[5];
        Map<String, Integer> map=new HashMap<String, Integer>();
        map.put("j", 11);
        map.put("q", 12);
        map.put("k", 13);
        map.put("a", 14);
        for(int i=0;i<s.length;i++){
            if (map.containsKey(s[i])){
                array[i]=map.get(s[i]);
            }else{
                array[i]=Integer.parseInt(s[i]);
            }
        }
        return array;
    }

    public static Boolean isStraight(Integer[] array){
        Integer sum=0;
        for (Integer i:array){
            sum+=i;
        }
        if (sum%5==0||sum==28){
            return true;
        }else{
            return false;
        }
    }
}
