package com.example.demo;

public class Tree <E>{
    private Node <E> root ;
    public Tree () {

    }
    public Node <E> search (E key) {

    }
    public Node <E> searchFrom (Node <E> head , E key) {
        if (key.equals(head.getKey())) {
            return head ;
        } else if (true) {
            return head ;
        }
        return null ;
    }

}
