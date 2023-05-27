package com.example.labreservesystem.utils;

import java.util.HashMap;
import java.util.Map;

public class DayCoursetoID {
    private Map<String,Character> map = new HashMap<String,Character>();

    public Map<String ,Character> getMap() {
        map.put("周一",'a');
        map.put("周二",'b');
        map.put("周三",'c');
        map.put("周四",'d');
        map.put("周五",'e');
        map.put("周六",'f');
        map.put("周天",'g');
        return map;
    }
}
