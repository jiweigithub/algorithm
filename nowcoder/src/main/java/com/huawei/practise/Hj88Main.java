package com.huawei.practise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Hj88Main{
    public static void main(String []args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while( (str = bf.readLine()) != null){
            String []ss = str.split("-");
            if(ss[0].equals("joker JOKER") || ss[1].equals("joker JOKER")){
                System.out.println("joker JOKER");
                continue;
            }
            String[] str0 = ss[0].split(" ");
            String[] str1 = ss[1].split(" ");
            str0 = findString(str0);
            str1 = findString(str1);
            int len0 = str0.length;
            int len1 = str1.length;

            if(len0 == 4 || len1 == 4){
                if(len0 == 4){
                    System.out.println(ss[0]);
                    continue;
                }else{
                    System.out.println(ss[1]);
                    continue;
                }

            }

            if(len0 != len1){
                System.out.println("ERROR");
                continue;
            }

            int temp = Integer.parseInt(str0[0]) - Integer.parseInt(str1[0]);
            if(temp >= 0){
                System.out.println(ss[0]);
                continue;
            }else{
                System.out.println(ss[1]);
                continue;
            }

        }
    }

    private static String[] findString(String[] str){
        for(int i = 0;i<str.length;i++){
            switch(str[i]){
                case "J":
                    str[i] = "11";
                    break;
                case "Q":
                    str[i] = "12";
                    break;
                case "K":
                    str[i] = "13";
                    break;
                case "A":
                    str[i] = "14";
                    break;
                case "2":
                    str[i] = "15";
                    break;
            }
        }
        return  str;
    }
}
