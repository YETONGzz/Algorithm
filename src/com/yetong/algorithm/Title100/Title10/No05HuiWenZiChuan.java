package com.yetong.algorithm.Title100.Title10;


import java.util.*;
import java.util.stream.Collectors;

public class No05HuiWenZiChuan {
    public static void main(String[] args) {
new No05HuiWenZiChuan().HuiWen("ababbbbb");
    }

    public String HuiWen(String str) {
        StringBuffer stringBuffer = new StringBuffer( str);
        Map<Integer,String> map = new HashMap<>();
        for (int i = 0; i < stringBuffer.length(); i++) {
            for (int j = i+1;j <= stringBuffer.length();j++){
                String substring = stringBuffer.substring(i, j);
                String temp = substring;
                if(temp.equals(new StringBuffer(substring).reverse().toString())){
                    map.put(temp.length(),temp);
                }
            }
        }
        Set<Integer> set = map.keySet();
        List<Integer> collect = set.stream().sorted((o1, o2) -> o2-o1).collect(Collectors.toList());
        System.out.println(collect.get(0));
        return "aa";
    }
}
