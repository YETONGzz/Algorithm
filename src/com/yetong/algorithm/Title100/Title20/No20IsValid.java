package com.yetong.algorithm.Title100.Title20;

import java.util.*;

/**
 * 是否是有效括号
 */
public class No20IsValid {
    public static void main(String[] args) {
        System.out.println(new No20IsValid().isValid("[]{(())}"));
    }


    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};

    public boolean isValid2(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0)))
            return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }};
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c))
                stack.addLast(c);
            else if (map.get(stack.removeLast()) != c)
                return false;
        }
        return stack.size() == 1;

    }

    //模拟栈来完成
    public boolean isValid(String str) {
        //第一个字符不是key直接返回false
        if (str.length() % 2 != 0 && map.containsKey(str.charAt(0))) {
            return false;
        }

        LinkedList<Character> list = new LinkedList<>();
        //先随便加入一个字符防止栈为空时在弹栈时报异常
        list.addLast('?');
        for (char c : str.toCharArray()) {
            //如果加入的事右开口的那么压栈
            if (map.containsKey(c)) {
                list.addLast(c);
                //如果不是右开口需要判断是否可以正确的根据映射关系进行弹栈操作
            } else if (map.get(list.removeLast()) != c) {
                return false;
            }
        }
        return list.size() == 1;
    }

    public boolean isValid3(String str) {
        if (str.length() < 2) {
            return false;
        }
        LinkedList<Character> que = new LinkedList();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                que.addLast(aChar);
            } else if (map.get(que.removeLast()) != aChar) {
                return false;
            }
        }
        return true;
    }
}
