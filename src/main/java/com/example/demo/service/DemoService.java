package com.example.demo.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class DemoService {

    public List<String> getListOfItems(){
        List<String> stringList = new ArrayList<>();
        stringList.add("Robot");
        stringList.add("Special");
        return stringList;
    }

    @PreAuthorize("isAuthenticated()")
    public Map<String, Integer> getMapOfItems(){
        Map<String, Integer> map = new TreeMap<>();
        map.put("S", 8);
        map.put("A", 9);
        map.put("I", 0);
        return map;
    }


}
