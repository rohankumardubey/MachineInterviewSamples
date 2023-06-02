package org.apache.practise.DeadLock;

import java.util.HashMap;

public class Sample {
    public static void main(String[] args) {
        // input from user
        // array of int
        // 5 < add numbers
        // greater than 5 multiply
        // 10,000 = 1
        // 100,000 = 0
        int[] sample = {540,12345678,9,999};
        generator(sample);
    }

    // {10,100,23,24567}
    public static void generator(int[] array){

        HashMap<Integer,Integer> flag = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            flag.put(array[i],String.valueOf(array[i]).length());
        }

        for(Integer key : flag.keySet()){
            if(flag.get(key)<=5){
                System.out.println(add(key));
            }
            else{
                System.out.println(multiply(key));
            }
        }
    }

    public static int multiply(int value){
        int temp =1;
        String number =  String.valueOf(value);
        for (int i = 0; i < number.length(); i++) {
            int ref =new Integer(number.charAt(i))-48;
            temp=temp*ref;
        }
        return temp;
    }

    public static int add(int value){
        int temp =0;
        String number =  String.valueOf(value);

        for (int i = 0; i < number.length(); i++) {
            int ref =new Integer(number.charAt(i))-48;
            temp=temp+ref;

        }
        return temp;
    }


}
