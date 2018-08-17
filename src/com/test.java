package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test {

    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
//        for (String item : list) {
//            if ("3".equals(item)) {
//                list.remove(item);
//            }
//        }
        Iterator<String> i=list.iterator();
        while (i.hasNext()){
            String item=i.next();
            if("3".equals(item)){
                i.remove();
            }
        }
        System.out.print(list.size());
    }
}
