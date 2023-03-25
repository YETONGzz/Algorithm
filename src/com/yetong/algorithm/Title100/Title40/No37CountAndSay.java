package com.yetong.algorithm.Title100.Title40;

/**
 * 外观数列
 */
public class No37CountAndSay {
    public static void main(String[] args) {
        No37CountAndSay countAndSay = new No37CountAndSay();
        System.out.println(countAndSay.countAndSay(4));
    }

    public String countAndSay(int n) {
        StringBuffer buffer = new StringBuffer("1");
        StringBuffer bufferTemp = new StringBuffer();
        char compare = '1';
        int count = 0;
        for (int i = 1; i < n; i++) {
            count = 0;
            bufferTemp = new StringBuffer();
            compare = buffer.charAt(0);
            for (int j = 0; j < buffer.length(); j++) {
                if (compare == buffer.charAt(j)) {
                    count++;
                } else {
                    bufferTemp.append(count + "" + compare);
                    compare = buffer.charAt(j);
                    count = 1;
                }
            }
            buffer = new StringBuffer(bufferTemp + "" + count + "" + compare);
        }
        return buffer.toString();
    }
}
