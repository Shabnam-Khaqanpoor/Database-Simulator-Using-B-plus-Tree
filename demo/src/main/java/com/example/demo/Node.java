//package com.example.demo;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Node<E> implements Comparable {
//    private Node<E> LeftParent=null;
//    private Node<E> RightParent=null;
//    private Node<E> LeftChild=null;
//    private Node<E> RightChild=null;
//    private Node<E> LeftBody=null;
//    private Node<E> RightBody=null;
//    private boolean isLeaf;
//    Map data;
//    private E key;
//
//    public Node() {
//        this.data = new HashMap<>();
//        this.isLeaf = true;
//        this.LeftChild = new Node<>();
//        this.RightChild = new Node<>();
//    }
//
//    public E getKey() {
//        return key;
//    }
//
//    public void setKey(E key) {
//        this.key = key;
//    }
//
//    public boolean isLeaf() {
//        return this.isLeaf;
//    }
//
//    public void setLeaf(boolean leaf) {
//        this.isLeaf = leaf;
//    }
//
//    public Node getLeftChild() {
//        return this.LeftChild;
//    }
//
//    public Node getRightChild() {
//        return this.RightChild;
//    }
//
//    public Node getLeftBody() {
//        return this.LeftBody;
//    }
//
//    public Node getRightBody() {
//        return this.RightBody;
//    }
//
//    public Node getLeftParent() {
//        return this.LeftParent;
//    }
//
//    public Node getRightParent() {
//        return this.RightParent;
//    }
//
//
//    public void setLeftChild(Node leftChild) {
//        this.LeftChild = leftChild;
//    }
//
//    public void setRightBody(Node rightBody) {
//        this.RightBody = rightBody;
//    }
//
//    public void setLeftBody(Node leftBody) {
//        this.LeftBody = leftBody;
//    }
//
//    public void setRightChild(Node rightChild) {
//        this.RightChild = rightChild;
//    }
//
//    public void setLeftParent(Node leftParent) {
//        this.LeftParent = leftParent;
//    }
//
//    public void setRightParent(Node rightParent) {
//        this.RightParent = rightParent;
//    }
//
//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
//}
