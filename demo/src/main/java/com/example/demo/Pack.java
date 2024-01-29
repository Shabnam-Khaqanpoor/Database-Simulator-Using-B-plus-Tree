package com.example.demo;

import java.util.ArrayList;
import java.util.List;
//باقی مجموعه اطلاعات (یک سطر) اینجانگه داری میشود
public class Pack implements Comparable {
    List values = new ArrayList<>();
    public Pack () {

    }
    public void addValue (Object o) {
        values.add(o);
    }
    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (int i = 0 ; i < values.size() ; i++) {
            text.append(values.get(i));
        }
        return String.valueOf(text);
    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
