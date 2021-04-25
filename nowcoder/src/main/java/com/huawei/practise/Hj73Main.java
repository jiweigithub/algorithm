package com.huawei.practise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 计算日期到天转换
 */
public class Hj73Main {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MM dd");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String dateString = scanner.nextLine();
            Date parse = dateFormat.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            int i = calendar.get(Calendar.DAY_OF_YEAR);
            System.out.println(i);
        }
    }
}
