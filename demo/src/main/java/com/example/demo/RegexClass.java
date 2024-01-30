package com.example.demo;

import java.util.regex.Pattern;

public abstract class RegexClass {
    public static boolean checkString(String input) {
        String regex = "[a-zA-Z0-9_]*" ;
        boolean t = Pattern.matches(regex , input);
        return t;
    }
    public static boolean checkDouble(String input) {
        String regex = "[0-9]*" ;
        boolean t1 = Pattern.matches(regex , input);
        regex = "[.]?" ;
        boolean t2 = Pattern.matches(regex , input);
        return (t1 && t2) ;
    }
    public static boolean checkDate(String input) {
        String regex = "[99]*" ;
        boolean t = Pattern.matches(regex , input);
        return t;
    }
    public static Type gettype (String input) {
        if (input.equals("String")){
            return Type.stringT ;
        } else if (input.equals("double")){
            return Type.doubleT ;
        } else if (input.equals("date")){
            return Type.dateT ;
        } else {
            return null ;
        }
    }
}
