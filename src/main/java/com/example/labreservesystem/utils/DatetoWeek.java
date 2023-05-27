package com.example.labreservesystem.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatetoWeek {

    public static void main(String[] args) throws ParseException {
        int res1,res2;
        res1 = DateToWorkWeekNo("2023-02-20", 1);
        res2 = DateToWorkWeekNo("2023-02-28",1);
        System.out.println(res1);
        System.out.println(res2);
    }

    /**
     * 根据输入的日期和指定的周开始天，计算周数
     *
     * @param dateVal  输入的日期
     * @param startDay 每周几为一周起始，输入7，即代表周日为一周的第一天，即周起始天
     * @return int
     */
    public static int DateToWorkWeekNo(String dateVal, int startDay) throws ParseException {
        int sFirstDay;
        double iDayOfYear;
        double iDayOfFirstWeek;
        String iYear;
        double res;
        int temp;

        iYear = dateVal.substring(0, 4);
        // 返回今年的 01/01 是周几，周一为1，周二为2 ......
        sFirstDay = getWeek(iYear + "-01-01");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date dt = dateFormat.parse(dateVal);
        Date dt2 = dateFormat.parse(iYear + "-01-01");

        // 输入日期是今年的第几天
        iDayOfYear = DateDiff(dt2, dt) + 1;

        // 计算第一周的天数  01/01周几 -  周起始日
        iDayOfFirstWeek = (sFirstDay - startDay) >= 0 ? 7 + startDay - sFirstDay : Math.abs(sFirstDay - startDay);

        // 返回周数
        // 输入的日期是否落在第一周内                Math.floor 向下取整，问题在于 VB 和 C# 的 int 转换在负数部分存在差异
        res = iDayOfYear <= iDayOfFirstWeek ? 1 : -Math.floor(-((iDayOfYear - iDayOfFirstWeek) / 7)) + 1;

        temp = (int) res;

        return temp;
    }

    public static int getWeek(String sdate) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int[] weeks = {7, 1, 2, 3, 4, 5, 6};
        Date parseDate = dateFormat.parse(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(parseDate);
        int week_index = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (week_index < 0) {
            week_index = 0;
        }
        return weeks[week_index];
    }

    /**
     * date2比date1多的天数
     *
     * @param date1 开始日期
     * @param date2 结束日期
     * @return int
     */
    public static int DateDiff(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) //不同年
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) //闰年
                {
                    timeDistance += 366;
                } else //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2 - day1);
        } else //同年
        {
//            System.out.println("判断day2 - day1 : " + (day2 - day1));
            return day2 - day1;
        }
    }

}
