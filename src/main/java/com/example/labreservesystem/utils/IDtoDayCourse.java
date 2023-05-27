package com.example.labreservesystem.utils;

import java.util.HashMap;
import java.util.Map;

public class IDtoDayCourse {
    private Map<Character,String> map = new HashMap<Character,String>();

    public Map<Character, String> getMap() {
        map.put('a',"周一");
        map.put('b',"周二");
        map.put('c',"周三");
        map.put('d',"周四");
        map.put('e',"周五");
        map.put('f',"周六");
        map.put('g',"周天");
        return map;
    }
}
