package com.example.demo;

public class Tree <E>{
    private Node <E> root = new Node<E>() ;
    public Tree () {

    }
    public Node <E> search (E key) {
        return null ;
    }
    public Node <E> searchFrom (Node <E> head , E key) {
        if (key.equals(head.getKey())) {
            return head;
        } else if (key.hashCode() < head.getKey().hashCode()) {
            if (!head.isLeaf()) {
                return searchFrom(head.getLeftChild(), key);
            } else {
                return head.getLeftChild() ;
            }
        } else if (key.hashCode() > head.getKey().hashCode()) {
            if (head.getRightBody() != null) {
                return searchFrom(head.getRightBody(), key);
            } else if (!head.isLeaf()){
                return searchFrom(head.getRightChild() , key) ;
            } else {
                return head.getRightChild() ;
            }
        } else {
            return root ;
        }
    }

}
