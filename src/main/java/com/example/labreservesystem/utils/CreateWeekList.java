package com.example.labreservesystem.utils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CreateWeekList {
    public List<String> getWeekList() {
        return weekList;
    }

    public void setWeekList(List<String> weekList) {
        this.weekList = weekList;
    }

    List<String> weekList = new ArrayList<String>();
    public void getWeekList(String startDate,int startWeekday,int weekNum){//开始日期，开始星期几，学期周总数


        WeektoDate weektoDate = new WeektoDate();
        for(int i = 0;i<weekNum;i++){
            String[] weekL = weektoDate.WToD(i,startDate);
            String w = "第" + (i+1) + "周  " + weekL[0] + "————" + weekL[1];
            weekList.add(w);
        }
//        for(String str:weekList){
//            System.out.println(str);
//        }
    }
}
