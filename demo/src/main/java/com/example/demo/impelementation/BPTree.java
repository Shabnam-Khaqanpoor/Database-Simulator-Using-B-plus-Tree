package com.example.demo.impelementation;

import java.util.ArrayList;
import java.util.List;

public class BPTree<TKey extends Comparable<TKey>, TValue> {
    private BTreeNode<TKey> root;
//    تعداد ستون ها و اسم ان ها
    private int colum ;
    private List <String> columName = new ArrayList<>() ;

    public String getColumName(int n) {
        return columName.get(n);
    }

    public int getColum() {
        return colum;
    }

    public BPTree() {
        this.root = new BTreeLeafNode<TKey, TValue>();
        this.colum = 0 ;
    }

    /**
     * Insert a new key and its associated value into the B+ tree.
     */
    public void insert(TKey key, TValue value , String name) {
        BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);
        leaf.insertKey(key, value);

        if (leaf.isOverflow()) {
            BTreeNode<TKey> n = leaf.dealOverflow();
            if (n != null)
                this.root = n;
        }
        colum ++ ;
        columName.add(name);
    }

    /**
     * Search a key value on the tree and return its associated value.
     */
    public TValue search(TKey key) {
        BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);

        int index = leaf.search(key);
        return (index == -1) ? null : leaf.getValue(index);
    }

    /**
     * Delete a key and its associated value from the tree.
     */
    public void delete(TKey key) {
        BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);

        if (leaf.delete(key) && leaf.isUnderflow()) {
            BTreeNode<TKey> n = leaf.dealUnderflow();
            if (n != null)
                this.root = n;
        }
    }

    /**
     * Search the leaf node which should contain the specified key
     */
    @SuppressWarnings("unchecked")
    private BTreeLeafNode<TKey, TValue> findLeafNodeShouldContainKey(TKey key) {
        BTreeNode<TKey> node = this.root;
        while (node.getNodeType() == TreeNodeType.InnerNode) {
            node = ((BTreeInnerNode<TKey>)node).getChild( node.search(key) );
        }

        return (BTreeLeafNode<TKey, TValue>)node;
    }
//    traverse
    public List<TKey> traverse () {
        List<TKey> nodes = new ArrayList<>() ;
        for (int i = 0; i < root.getKeyCount(); ++i) {
            nodes.add(this.root.getKey(i));
        }
        return nodes ;
    }
}
