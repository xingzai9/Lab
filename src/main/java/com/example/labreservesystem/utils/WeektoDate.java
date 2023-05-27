package com.example.labreservesystem.utils;

public class WeektoDate {

    public String[] WToD(int weekOrder,String startDate)
    {
        int leapMonth[] = new int[]{31,29,31,30,31,30,31,30,31,30,31,30};
        int commonMonth[] = new int[]{31,28,31,30,31,30,31,30,31,30,31,30};
        int year = Integer.parseInt(startDate.substring(0,4));
        int month = Integer.parseInt(startDate.substring(5,7));
        int day = Integer.parseInt(startDate.substring(8,10));
        String start,end;
        if(year%4==0 && year%100!=0 || year%400==0){//闰年
//            int m = month;
            while(weekOrder!=0){
                if(leapMonth[month-1] - day < 7){

                    day = 7 - (leapMonth[month-1] - day);
                    month++;
                    weekOrder--;
                }
                else{
                    day = day + 6;
                    weekOrder--;
                }
            }
            start = month + "月" + day + "日";
            if(leapMonth[month-1] - day < 7){

                day = 7 - (leapMonth[month-1] - day+1);
                month++;
            }
            else{
                day = day + 6;
            }
            end = month + "月" + day + "日";

        }
        else{
            while(weekOrder !=0){
                if(commonMonth[month-1] - day < 7){

                    day = 7 - (commonMonth[month-1] - day);
                    month++;
                    weekOrder--;
                }
                else{
                    day = day + 7;
                    weekOrder--;
                }
            }
            start = month + "月" + day + "日";
            if(commonMonth[month-1] - day < 7){

                day = 7 - (commonMonth[month-1] - day+1);
                month++;
            }
            else{
                day = day + 6;
            }
            end = month + "月" + day + "日";
        }
        String str[] = new String[]{start,end};
        return str;
    }
}
