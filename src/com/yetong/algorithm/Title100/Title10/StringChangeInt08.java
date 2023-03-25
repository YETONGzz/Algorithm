package com.yetong.algorithm.Title100.Title10;

public class StringChangeInt08 {  // 48 57
    public static void main(String[] args) {
        System.out.println(change("words and 987"));
    }

    public static int change(String str) {
        StringBuffer temp = new StringBuffer(str);
        String head = "";
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == 45) {
                head += temp.charAt(i);
                temp.delete(i, i + 1);
                System.out.println(head);
                break;
            }
        }
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) < 48 || temp.charAt(i) > 57 && i < temp.length()) {
                temp.delete(i, i + 1);
                i--;
            }
        }
        if (head != null) {
            temp.insert(0, head);
        }
        return Integer.valueOf("" + temp);
    }
}
