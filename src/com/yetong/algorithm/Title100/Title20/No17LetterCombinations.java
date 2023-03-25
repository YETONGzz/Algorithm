package com.yetong.algorithm.Title100.Title20;

import com.sun.xml.internal.ws.util.StringUtils;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

/**
 * 电话数字组合
 */
public class No17LetterCombinations {
    public static void main(String[] args) {
        //letterCombinations("234");
        System.out.println(letterCombinations2("2"));
    }

    static String[] letter_map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        //注意边界条件
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        iterStr(digits, new StringBuilder(), 0);
        return res;
    }

    //最终输出结果的list
    static List<String> res = new ArrayList<>();

    List<String> resList = new ArrayList<>();

    //递归函数
    static void iterStr(String str, StringBuilder letter, int index) {
        //递归的终止条件，注意这里的终止条件看上去跟动态演示图有些不同，主要是做了点优化
        //动态图中是每次截取字符串的一部分，"234"，变成"23"，再变成"3"，最后变成""，这样性能不佳
        //而用index记录每次遍历到字符串的位置，这样性能更好
        if (index == str.length()) {
            res.add(letter.toString());
            return;
        }
        //获取index位置的字符，假设输入的字符是"234"
        //第一次递归时index为0所以c=2，第二次index为1所以c=3，第三次c=4
        //subString每次都会生成新的字符串，而index则是取当前的一个字符，所以效率更高一点
        char c = str.charAt(index);
        //map_string的下表是从0开始一直到9， c-'0'就可以取到相对的数组下标位置
        //比如c=2时候，2-'0'，获取下标为2,letter_map[2]就是"abc"
        int pos = c - '0';
        String map_string = letter_map[pos];
        //遍历字符串，比如第一次得到的是2，页就是遍历"abc"
        for (int i = 0; i < map_string.length(); i++) {
            //调用下一层递归，用文字很难描述，请配合动态图理解
            letter.append(map_string.charAt(i));
            //如果是String类型做拼接效率会比较低
            //iterStr(str, letter+map_string.charAt(i), index+1);
            iterStr(str, letter, index + 1);
            letter.deleteCharAt(letter.length() - 1);
        }
    }


    public static List<String> letterCombinations2(String digits) {
        //注意边界条件
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        //递归回溯 buffer用来控制对截取的字符的拼接  index用来控制截取数字所对应的字母中的那个字符
        reCall(digits, new StringBuffer(), 0);
        return res;
    }

    public static void reCall(String str, StringBuffer buffer, int index) {
        //每一层循环的递归结束条件 档index等于数字长度时说明当前所截取的字符是最后的一组字符
        if (index == str.length()) {
            res.add(buffer.toString());
            return;
        }

        char c = str.charAt(index);
        int post = c - '0';
        String letter = letter_map[post];
        for (int i = 0; i < letter.length(); i++) {
            buffer.append(letter.charAt(i));
            reCall(str, buffer, index + 1);
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }


    public List<String> letterCombinations3(String str) {
        if (str.equals("")) {
            return new ArrayList<String>();
        }
        dfs(str,new StringBuffer(),0);
        return resList;
    }

    public void dfs(String str, StringBuffer res, int index) {
        if (str.length() == index) {
            resList.add(res.toString());
            return;
        }
        char c = str.charAt(index);
        char val = '0';
        String buf = letter_map[c - val];
        for (int i = 0; i < buf.length(); i++) {
            res.append(buf.charAt(i));
            dfs(str, res, index + 1);
            res.deleteCharAt(res.length() - 1);
        }
    }

}
