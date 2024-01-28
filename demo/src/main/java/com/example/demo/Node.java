package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node <E> implements Comparable{
    private Node LeftParent ;
    private Node RightParent ;
    private Node LeftChild ;
    private Node RightChild ;
    private Node LeftBody ;
    private Node RightBody ;
    Map data ;
    private E key ;
    public Node () {
        data = new HashMap<>() ;
    }
    public E getKey() {
        return key;
    }
    public void setKey(E key) {
        this.key = key;
    }


    public Node getLeftChild() {
        return LeftChild;
    }
    public Node getRightChild() {
        return RightChild;
    }
    public Node getLeftBody() {
        return LeftBody;
    }
    public Node getRightBody() {
        return RightBody;
    }
    public Node getLeftParent() {
        return LeftParent;
    }
    public Node getRightParent() {
        return RightParent;
    }


    public void setLeftChild(Node leftChild) {
        LeftChild = leftChild;
    }
    public void setRightBody(Node rightBody) {
        RightBody = rightBody;
    }
    public void setLeftBody(Node leftBody) {
        LeftBody = leftBody;
    }
    public void setRightChild(Node rightChild) {
        RightChild = rightChild;
    }
    public void setLeftParent(Node leftParent) {
        LeftParent = leftParent;
    }
    public void setRightParent(Node rightParent) {
        RightParent = rightParent;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
