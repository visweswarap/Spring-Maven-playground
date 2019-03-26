package com.vish.springmaven.rough;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {

        int x = 10;
        Integer y = new Integer(10);

        if(x == y){
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        Map<String, String> child1 = new HashMap<>();
        child1.put("aaa","ABABAB");
        child1.put("bbb","BCBCBC");

        Map<String, String> child2 = new HashMap<>();
        child2.put("ccc","CDCDCD");
        child2.put("ddd","DEDEDE");

        Map<String, Map<String, String>> outerMap = new HashMap<>();
        outerMap.put("child1", child1);
        outerMap.put("child2", child2);

        outerMap.get("");

        Stream<Map<String, String>> mapStream = outerMap.entrySet()
                .stream()
                .map(entry -> {
                    String globalKey = entry.getKey();
                    Map<String, String> collect = entry.getValue().entrySet().stream().collect(Collectors.toMap(entry1 -> globalKey + "_" + entry1.getKey(), entry1 -> entry1.getValue()));
                    return collect;
                });
        //Map<String, String> any = mapStream.collect(Collectors.toMap());

        System.out.println("asdfasdv");

    }




}
