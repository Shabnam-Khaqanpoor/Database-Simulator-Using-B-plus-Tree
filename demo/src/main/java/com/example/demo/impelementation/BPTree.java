package com.example.demo.impelementation;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class BPTree<TKey extends Comparable<TKey>, TValue> {
    private String name = "simple" ;

    public String getName() {
        return name;
    }
    private List<String> columnNames = new ArrayList<>() ;

    public List<String> getColumnNames() {
        return this.columnNames;
    }
    public String getColumn (int n) {
        return columnNames.get(n) ;
    }

    public void addColumnName (String name) {
        columnNames.add(name);
    }
    private int size = 0;

    public int getSize() {
        return size;
    }

    private BTreeNode<TKey> root;
//    تعداد ستون ها و اسم ان ها

    public BPTree() {
        this.root = new BTreeLeafNode<TKey, TValue>();
    }
    public BPTree(String name) {
        this.root = new BTreeLeafNode<TKey, TValue>();
        this.name = name ;
    }

    /**
     * Insert a new key and its associated value into the B+ tree.
     */
    public void insert(TKey key, TValue value) {
        BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);
        leaf.insertKey(key, value);

        if (leaf.isOverflow()) {
            BTreeNode<TKey> n = leaf.dealOverflow();
            if (n != null)
                this.root = n;
        }
        size ++ ;
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
            size -- ;
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
