package com.example.myhead.one.controller;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {

        Map<String, Object> data = new HashMap<>();
        data.put("1", 11);
        data.put("2", 22);
        data.put("3", 33);
        data.put("4", 44);
//      遍历map
        for (String key : data.keySet()){
            System.out.println("value:" + data.get(key));
        }

        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
            System.out.println(arr[i]);
        }
    }
}
