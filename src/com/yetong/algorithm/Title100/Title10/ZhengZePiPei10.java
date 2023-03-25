package com.yetong.algorithm.Title100.Title10;

public class ZhengZePiPei10 {
    public static void main(String[] args) {
        System.out.println(zhengZePiPei("aa","a*"));
        System.out.println("a*".substring(0,1));
    }

    public static boolean zhengZePiPei(String str,String regx){
        if(regx.equals(".*")){
            return true;
        }
        if(regx.length()==1){
            return str.equals(regx);
        }
        if (regx.substring(regx.length()-1,regx.length()).equals(".")) {
            if(str.equals(regx.substring(regx.length()-2,regx.length()-1))){
                return true;
            }else return false;
        }else if(regx.substring(regx.length()-1,regx.length()).equals("*")) {
            if(str.equals(regx.substring(0,regx.length()-1))){
                return true;
            }
            if(loopRegx(str,regx.substring(0,regx.length()-1))){
                return true;
            }
        }else if(regx.length()>2&&regx.substring(regx.length()-2,regx.length()).equals(".*")){
            if(str.equals(regx.substring(0,regx.length()-2))){
                return true;
            }else return false;
        }else if(str.equals(regx)){
            return true;
        }return false;
    }

    public static boolean loopRegx(String str,String regx){
        if(str.length()%regx.length()!=0){
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            return false;
        }
        System.out.println("bbbbbbbbbbbbbbbbbbbb");
        int x = str.length()/regx.length();
        for (int i = 0;i < x;i++){
            if(!str.substring(i*regx.length(),(i+1)*regx.length()).equals(regx)){
                return false;
            }
        }
        return true;
    }
}
