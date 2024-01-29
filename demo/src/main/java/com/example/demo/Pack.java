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
    public int compareTo(Object o) {
        return 0;
    }
}
