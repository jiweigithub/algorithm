package com.huawei.practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 考试题目和要点：
 *
 * 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。
 *
 * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。
 *
 * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如6007.14，应写成“人民币陆仟零柒元壹角肆分“。
 * 4、10应写作“拾”，100应写作“壹佰”。例如，1010.00应写作“人民币壹仟零拾元整”，110.00应写作“人民币壹佰拾元整”
 * 5、十万以上的数字接千不用加“零”，例如，30105000.00应写作“人民币叁仟零拾万伍仟元整”
 *
 * 本题含有多组样例输入。
 *
 * 输入描述:
 * 输入一个double数
 *
 * 输出描述:
 * 输出人民币格式
 *
 * 示例1
 * 输入
 * 复制
 * 151121.15
 * 10012.02
 * 输出
 * 复制
 * 人民币拾伍万壹仟壹佰贰拾壹元壹角伍分
 * 人民币壹万零拾贰元贰分
 */
public class Hj95Main{
    private static String[] chineseNum = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    private static String[] chineseUnit = {null,"拾","佰","仟","万","拾","佰","仟","亿"};
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            String zn;
            String sn=null;
            if(str.contains(".")){
                String[] split=str.split("\\.");
                zn=split[0];
                sn=split[1];
            }else{
                zn=str;
            }
            String res=format(zn);
            StringBuilder sb=new StringBuilder(res);
            if(!"人民币".equals(res)){
                sb.append("元");
            }
            if(sn==null||"00".equals(sn))
                sb.append("整");
            else{
                int jn=Integer.parseInt(String.valueOf(sn.charAt(0)));
                if(jn!=0){
                    sb.append(chineseNum[jn]);
                    sb.append("角");
                }
                int fn=Integer.parseInt(String.valueOf(sn.charAt(1)));
                if(fn!=0){
                    sb.append(chineseNum[fn]);
                    sb.append("分");
                }
            }
            System.out.println(sb.toString());
        }
    }
    public static String format(String zn){
        StringBuilder sb=new StringBuilder("人民币");
        boolean hasZero=false;
        if("0".equals(zn)){
            return sb.toString();
        }
        for(int i=0;i<zn.length();i++){
            int unitIndex=zn.length()-i-1;
            int n=Integer.parseInt(String.valueOf(zn.charAt(i)));
            switch(n){
                case 0:
                    if(!hasZero&&unitIndex!=4){
                        sb.append(chineseNum[0]);
                        hasZero=true;
                    }
                    break;
                case 1:
                    if(!"拾".equals(chineseUnit[unitIndex])){
                        sb.append(chineseNum[1]);
                    }
                    hasZero=false;
                    break;
                default:
                    sb.append(chineseNum[n]);
                    hasZero=false;
                    break;
            }
            if(chineseUnit[unitIndex]!=null){
                if(!hasZero) sb.append(chineseUnit[unitIndex]);
            }
        }
        if(sb.charAt(sb.length()-1)=='零')
            return sb.substring(0,sb.length()-1);
        else
            return sb.toString();
    }
}