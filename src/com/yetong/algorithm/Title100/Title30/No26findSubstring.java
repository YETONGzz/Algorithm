package com.yetong.algorithm.Title100.Title30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 串联所有单词的子串
 */
public class No26findSubstring {
    public static void main(String[] args) {
        No26findSubstring no26findSubstring = new No26findSubstring();
        String[] a = {"word", "good", "best", "word"};
        String str = "wordgoodgoodgoodbestword";
        System.out.println(no26findSubstring.findSubString(str, a));
    }

    List<String> list = new ArrayList<>();

    public List<String> getAll(String[] strings) {
        if (strings.length == 0) {
            return list;
        }
        if (strings.length == 1) {
            list.add(strings[0]);
            return list;
        }
        int k = 0;
        dsf(strings, new StringBuffer(), 0);
        return list;
    }

    public void dsf(String[] strings, StringBuffer str, int end) {
        if (end == 4) {
            list.add(str.toString());
            return;
        }
        for (int i = end; i < strings.length; i++) {
            str.append(strings[i]);
            dsf(strings, str, end + 1);

        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length();
        //HashMap1 存所有单词
        HashMap<String, Integer> allWords = new HashMap<String, Integer>();
        for (String w : words) {
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }
        int cycles = s.length() - wordNum * wordLen + 1;
        //遍历所有子串
        for (int i = 0; i < cycles; i++) {
            //HashMap2 存当前扫描的字符串含有的单词
            HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
            int num = 0;
            //判断该子串是否符合
            while (num < wordNum) {
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                //判断该单词在 HashMap1 中
                if (allWords.containsKey(word)) {
                    int value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word, value + 1);
                    //判断当前单词的 value 和 HashMap1 中该单词的 value
                    if (hasWords.get(word) > allWords.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            //判断是不是所有的单词都符合条件
            if (num == wordNum) {
                res.add(i);
            }
        }
        return res;
    }


    public List<Integer> findSubString(String pattern, String[] str) {
        ArrayList<Integer> list = new ArrayList<>();
        if (str.length == 0) {
            return list;
        }
        //存放全部单词个数的哈希表 将单词作为key 将单词出现的次数作为value
        HashMap<String, Integer> strMap = new HashMap<>();
        for (String s : str) {
            //如果map中含有该key返回对应的value 否则返回默认值
            Integer value = strMap.getOrDefault(s, 0);
            strMap.put(s, value + 1);
        }

        int wordNum = str.length;
        int wordLen = str[0].length();
        //遍历模式串（原串）的次数
        int cycles = pattern.length() - wordNum * wordLen + 1;
        for (int i = 0; i < cycles; i++) {
            HashMap<String, Integer> patternMap = new HashMap<>();
            //用来控制截取单词的哈希表与全部单词的哈希表判断的次数
            int num = 0;
            //小于单词个数时才进行哈希表匹配判断
            while (num < wordNum) {
                String substring = pattern.substring(i + num * wordLen, i + (num + 1) * wordLen);
                if (strMap.containsKey(substring)) {
                    Integer value = patternMap.getOrDefault(substring, 0);
                    patternMap.put(substring, value + 1);
                    if (strMap.get(substring) < patternMap.get(substring)) {
                        break;
                    }
                    num++;
                } else {
                    break;
                }
            }
            if (num == wordNum) {
                list.add(i);
            }
        }
        return list;
    }

    //使用滑动窗口
    public List<Integer> findSubstringYouHua(String pattern, String[] str) {
        ArrayList<Integer> list = new ArrayList<>();
        if (str.length == 0) {
            return list;
        }
        //存放全部单词个数的哈希表 将单词作为key 将单词出现的次数作为value
        HashMap<String, Integer> strMap = new HashMap<>();
        for (String s : str) {
            //如果map中含有该key返回对应的value 否则返回默认值
            Integer value = strMap.getOrDefault(s, 0);
            strMap.put(s, value + 1);
        }
        int wordNum = str.length;
        int wordLen = str[0].length();

        for (int j = 0; j < wordLen; j++) {
            HashMap<String, Integer> patternMap = new HashMap<String, Integer>();
            int num = 0;
            int cycles = pattern.length() - wordNum * wordLen + 1;
            for (int i = j; i < cycles; i += wordLen) {
                while (num < wordNum) {
                    boolean hasRemoved = false;
                    String word = pattern.substring(i + num * wordLen, i + (num + 1) * wordLen);
                    if (strMap.containsKey(word)) {
                        int value = patternMap.getOrDefault(word, 0);
                        patternMap.put(word, value + 1);
                        //出现情况三，遇到了符合的单词，但是次数超了
                        if (patternMap.get(word) > strMap.get(word)) {
                            // hasWords.put(word, value);
                            hasRemoved = true;
                            int removeNum = 0;
                            //一直移除单词，直到次数符合了
                            while (strMap.get(word) > patternMap.get(word)) {
                                String firstWord = pattern.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
                                int v = patternMap.get(firstWord);
                                patternMap.put(firstWord, v - 1);
                                removeNum++;
                            }
                            num = num - removeNum + 1; //加 1 是因为我们把当前单词加入到了 HashMap 2 中
                            i = i + (removeNum - 1) * wordLen; //这里依旧是考虑到了最外层的 for 循环，看情况二的解释
                            break;
                        }
                        //出现情况二，遇到了不匹配的单词，直接将 i 移动到该单词的后边（但其实这里
                        //只是移动到了出现问题单词的地方，因为最外层有 for 循环， i 还会移动一个单词
                        //然后刚好就移动到了单词后边）
                    } else {
                        patternMap.clear();
                        i = i + num * wordLen;
                        num = 0;
                        break;
                    }
                    num++;
                    if (num == wordNum) {
                        list.add(i);
                    }
                    //出现情况一，子串完全匹配，我们将上一个子串的第一个单词从 HashMap2 中移除
                    if (num > 0 && !hasRemoved) {
                        String firstWord = pattern.substring(i, i + wordLen);
                        int v = patternMap.get(firstWord);
                        patternMap.put(firstWord, v - 1);
                        num = num - 1;
                    }
                }
            }
        }
        return list;

    }

    public List<Integer> findSubstring3(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length();
        HashMap<String, Integer> allWords = new HashMap<String, Integer>();
        for (String w : words) {
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }
        //将所有移动分成 wordLen 类情况
        for (int j = 0; j < wordLen; j++) {
            HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
            int num = 0; //记录当前 HashMap2（这里的 hasWords 变量）中有多少个单词
            //每次移动一个单词长度
            for (int i = j; i < s.length() - wordNum * wordLen + 1; i = i + wordLen) {
                boolean hasRemoved = false; //防止情况三移除后，情况一继续移除
                while (num < wordNum) {
                    String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                    if (allWords.containsKey(word)) {
                        int value = hasWords.getOrDefault(word, 0);
                        hasWords.put(word, value + 1);
                        //出现情况三，遇到了符合的单词，但是次数超了
                        if (hasWords.get(word) > allWords.get(word)) {
                            // hasWords.put(word, value);
                            hasRemoved = true;
                            int removeNum = 0;
                            //一直移除单词，直到次数符合了
                            while (hasWords.get(word) > allWords.get(word)) {
                                String firstWord = s.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
                                int v = hasWords.get(firstWord);
                                hasWords.put(firstWord, v - 1);
                                removeNum++;
                            }
                            num = num - removeNum + 1; //加 1 是因为我们把当前单词加入到了 HashMap 2 中
                            i = i + (removeNum - 1) * wordLen; //这里依旧是考虑到了最外层的 for 循环，看情况二的解释
                            break;
                        }
                        //出现情况二，遇到了不匹配的单词，直接将 i 移动到该单词的后边（但其实这里
                        //只是移动到了出现问题单词的地方，因为最外层有 for 循环， i 还会移动一个单词
                        //然后刚好就移动到了单词后边）
                    } else {
                        hasWords.clear();
                        i = i + num * wordLen;
                        num = 0;
                        break;
                    }
                    num++;
                }
                if (num == wordNum) {
                    res.add(i);

                }
                //出现情况一，子串完全匹配，我们将上一个子串的第一个单词从 HashMap2 中移除
                if (num > 0 && !hasRemoved) {
                    String firstWord = s.substring(i, i + wordLen);
                    int v = hasWords.get(firstWord);
                    hasWords.put(firstWord, v - 1);
                    num = num - 1;
                }

            }

        }
        return res;
    }


}
