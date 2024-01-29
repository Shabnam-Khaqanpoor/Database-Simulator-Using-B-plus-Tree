//package com.example.demo;
//
//public class BPTree<E>{
//    private Node <E> root = new Node<E>() ;
//    public BPTree() {}
//    public Node <E> search (E key) {
//        if (this.root != null) {
//            return searchFrom(this.root, key);
//        } else {
//            return null ;
//        }
//    }
//    public Node <E> searchFrom (Node <E> head , E key) {
//        if (key.equals(head.getKey())) {
//            return head;
//        } else if (key.hashCode() < head.getKey().hashCode()) {
//            if (!head.isLeaf()) {
//                return searchFrom(head.getLeftChild(), key);
//            } else {
//                return head.getLeftChild() ;
//            }
//        } else if (key.hashCode() > head.getKey().hashCode()) {
//            if (head.getRightBody() != null) {
//                return searchFrom(head.getRightBody(), key);
//            } else if (!head.isLeaf()){
//                return searchFrom(head.getRightChild() , key) ;
//            } else {
//                return head.getRightChild() ;
//            }
//        } else {
//            return this.root ;
//        }
//    }
//
//    public void insert(E key, Object value) {
//        if (key == null) {
//            throw new IllegalArgumentException("Key cannot be null");
//        }
//
//        // Perform the insertion
//        insertKey(this.root, key, value);
//
//        // Check if the root was split, and create a new root if needed
//        if (this.root.isLeaf()) {
//            Node<E> newRoot = new Node<>();
//            newRoot.setLeftChild(this.root);
//            newRoot.setKey(this.root.getKey());
//            newRoot.setRightChild(null); // Assuming no right child for the rootz
//            this.root = newRoot;
//        }
//    }
//
//    private void insertKey(Node<E> node, E key, Object value) {
//        // TODO: Implement the logic to insert a key into the B+ tree
//        // This may involve splitting nodes and updating parent pointers
//    }
//
//    public Node<E> delete(E key) {
//        // Perform the deletion
//        Node<E> deletedNode = deleteKey(this.root, key);
//
//        // Check if the root has only one child, update the root
//        if (this.root.getLeftChild() != null && this.root.getRightChild() == null) {
//            this.root = this.root.getLeftChild();
//        } else if (this.root.getLeftChild() == null && this.root.getRightChild() != null) {
//            this.root = this.root.getRightChild();
//        }
//
//        return deletedNode;
//    }
//
//    private Node<E> deleteKey(Node<E> node, E key) {
//        // TODO: Implement the logic to delete a key from the B+ tree
//        // This may involve merging nodes and updating parent pointers
//        return null;
//    }
//
//    // Helper method for splitting a node during insertion
//    private void splitNode(Node<E> node) {
//        // TODO: Implement node splitting logic
//    }
//
//    // Helper method for merging nodes during deletion
//    private void mergeNodes(Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
//        // TODO: Implement node merging logic
//    }
//}
