package com.yetong.algorithm.Title100.Title10;

/**
 * z字形变换
 */
public class ZChange06 {
    public static void main(String[] args) {
        System.out.println(convert("abcdefg", 3));
    }

    public static String convert(String str, int numRow){
        int layer = numRow+numRow-2;
        int move = numRow-2;
        int column = 0;
        int k = 1;
        int y = 2;
        if(numRow ==1){
            return str;
        }
        if(numRow==2){
            column = str.length()/2+str.length()%2;
        }else {
            column = str.length()/(layer);
            column = column*2+column%str.length()/(numRow+numRow-2);
        }
        int num = 0;
        char[][] res = new char[100][100];
        for (int i = 0;i < column;i++){
            for (int j = 0;j < layer;j++){
                if(num==13){
                    i=100;
                    break;
                }
                if(j>numRow-1&&k<move){
                    if(k<move){
                        res[i+k][numRow-y] = str.charAt(num++);
                        k++;
                    }
                    if(k>=move){
                        i = i+k;
                    }
                }else {
                    res[j][i] = str.charAt(num++);
                }
            }
        }
        String s = "";
        for (int i = 0;i < numRow;i++){
            for (int j = 0;j < column;j++){
                if(res[i][j]!=0){
                    s+= res[i][j];
                }

            }
        }
        return s;
    }



}
