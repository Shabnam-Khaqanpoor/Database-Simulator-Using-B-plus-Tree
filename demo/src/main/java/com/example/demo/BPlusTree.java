//<<<<<<< HEAD
//package com.example.demo;
//
//import java.util.ArrayList;
//import java.util.List;
//
////class Node {
////    int order;
////    List<String> values;
////    List<List<String>> keys;
////    Node nextKey;
////    Node parent;
////    boolean checkLeaf;
////
////    public Node(int order) {
////        this.order = order;
////        this.values = new ArrayList<>();
////        this.keys = new ArrayList<>();
////        this.nextKey = null;
////        this.parent = null;
////        this.checkLeaf = false;
////    }
////
////    // Insert at the leaf
////    public void insertAtLeaf(Node leaf, String value, String key) {
////        if (!this.values.isEmpty()) {
////            List<String> temp1 = this.values;
////            for (int i = 0; i < temp1.size(); i++) {
////                if (value.equals(temp1.get(i))) {
////                    this.keys.get(i).add(key);
////                    break;
////                } else if (value.compareTo(temp1.get(i)) < 0) {
////                    this.values.add(i, value);
////                    this.keys.add(i, new ArrayList<>(List.of(key)));
////                    break;
////                } else if (i + 1 == temp1.size()) {
////                    this.values.add(value);
////                    this.keys.add(new ArrayList<>(List.of(key)));
////                    break;
////                }
////            }
////        } else {
////            this.values.add(value);
////            this.keys.add(new ArrayList<>(List.of(key)));
////        }
////    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//class BplusTree {
//    Node root;
//
//    public BplusTree(int order) {
//        this.root = new Node(order);
//        this.root.checkLeaf = true;
//    }
//
//    // Insert operation
//    public void insert(String value, String key) {
//        value = String.valueOf(value);
//        Node oldNode = search(value);
//        oldNode.insertAtLeaf(oldNode, value, key);
//
//        if (oldNode.values.size() == oldNode.order) {
//            Node newNode = new Node(oldNode.order);
//            newNode.checkLeaf = true;
//            newNode.parent = oldNode.parent;
//            int mid = (int) Math.ceil(oldNode.order / 2.0) - 1;
//            newNode.values = new ArrayList<>(oldNode.values.subList(mid + 1, oldNode.order));
//            newNode.keys = new ArrayList<>(oldNode.keys.subList(mid + 1, oldNode.order));
//            newNode.nextKey = oldNode.nextKey;
//            oldNode.values.subList(mid + 1, oldNode.order).clear();
//            oldNode.keys.subList(mid + 1, oldNode.order).clear();
//            oldNode.nextKey = newNode;
//            insertInParent(oldNode, newNode.values.get(0), newNode);
//        }
//    }
//
//    // Search operation for different operations
//    public Node search(String value) {
//        Node currentNode = this.root;
//        while (!currentNode.checkLeaf) {
//            List<String> temp2 = currentNode.values;
//            for (int i = 0; i < temp2.size(); i++) {
//                if (value.equals(temp2.get(i))) {
//                    currentNode = (Node) currentNode.keys.get(i + 1);
//                    break;
//                } else if (value.compareTo(temp2.get(i)) < 0) {
//                    currentNode = (Node) currentNode.keys.get(i);
//                    break;
//                } else if (i + 1 == temp2.size()) {
//                    currentNode = (Node) currentNode.keys.get(i + 1);
//                    break;
//                }
//            }
//        }
//        return currentNode;
//    }
//
//    // Find the node
//    public boolean find(String value, String key) {
//        Node node = search(value);
//        for (int i = 0; i < node.values.size(); i++) {
//            if (value.equals(node.values.get(i))) {
//                return node.keys.get(i).contains(key);
//            }
//        }
//        return false;
//    }
//
//    // Inserting at the parent
//    public void insertInParent(Node n, String value, Node ndash) {
//        if (this.root == n) {
//            Node rootNode = new Node(n.order);
//            rootNode.values = new ArrayList<>(List.of(value));
//            rootNode.keys = new ArrayList<>(List.of(n, ndash));
//            this.root = rootNode;
//            n.parent = rootNode;
//            ndash.parent = rootNode;
//            return;
//        }
//
//        Node parentNode = n.parent;
//        List<Node> temp3 = parentNode.keys;
//        for (int i = 0; i < temp3.size(); i++) {
//            if (temp3.get(i) == n) {
//                parentNode.values.add(i, value);
//                parentNode.keys.add(i + 1, ndash);
//                if (parentNode.keys.size() > parentNode.order) {
//                    Node parentDash = new Node(parentNode.order);
//                    parentDash.parent = parentNode.parent;
//                    int mid = (int) Math.ceil(parentNode.order / 2.0) - 1;
//                    parentDash.values = new ArrayList<>(parentNode.values.subList(mid + 1, parentNode.order));
//                    parentDash.keys = new ArrayList<>(parentNode.keys.subList(mid + 1, parentNode.order));
//                    String value_ = parentNode.values.get(mid);
//                    if (mid == 0) {
//                        parentNode.values = new ArrayList<>(parentNode.values.subList(0, mid + 1));
//                    } else {
//                        parentNode.values = new ArrayList<>(parentNode.values.subList(0, mid));
//                    }
//                    parentNode.keys = new ArrayList<>(parentNode.keys.subList(0, mid + 1));
//                    for (Node j : parentNode.keys) {
//                        j.parent = parentNode;
//                    }
//                    for (Node j : parentDash.keys) {
//                        j.parent = parentDash;
//                    }
//                    insertInParent(parentNode, value_, parentDash);
//                }
//            }
//        }
//    }
//
//    // Delete a node
//    public void delete(String value, String key) {
//        Node node = search(value);
//
//        int temp = 0;
//        for (int i = 0; i < node.values.size(); i++) {
//            if (value.equals(node.values.get(i))) {
//                temp = 1;
//
//                if (node.keys.get(i).contains(key)) {
//                    if (node.keys.get(i).size() > 1) {
//                        node.keys.get(i).remove(key);
//                    } else if (node == this.root) {
//                        node.values.remove(i);
//                        node.keys.remove(i);
//                    } else {
//                        node.keys.get(i).remove(key);
//                        node.keys.remove(i);
//                        node.values.remove(node.values.indexOf(value));
//                        deleteEntry(node, value, key);
//                    }
//                } else {
//                    System.out.println("Value not in Key");
//                    return;
//                }
//            }
//        }
//        if (temp == 0) {
//            System.out.println("Value not in Tree");
//        }
//    }
//
//    // Delete an entry
//    public void deleteEntry(Node node, String value, String key) {
//
//        if (!node.checkLeaf) {
//            for (int i = 0; i < node.keys.size(); i++) {
//                if (node.keys.get(i) == key) {
//                    node.keys.remove(i);
//                    break;
//                }
//            }
//            for (int i = 0; i < node.values.size(); i++) {
//                if (node.values.get(i) == value) {
//                    node.values.remove(i);
//                    break;
//                }
//            }
//        }
//
//        if (this.root == node && node.keys.size() == 1) {
//            this.root = node.keys.get(0);
//            node.keys.get(0).parent = null;
//            node.keys.get(0).nextKey = null;
//            node.keys.remove(0);
//        }
//    }
//
//    // Print the tree
//    public void printTree() {
//        List<Node> lst = new ArrayList<>();
//        List<Integer> level = new ArrayList<>();
//        Node leaf = null;
//        int flag = 0;
//        int lev_leaf = 0;
//
//        lst.add(this.root);
//        level.add(0);
//
//        while (!lst.isEmpty()) {
//            Node x = lst.remove(0);
//            int lev = level.remove(0);
//            if (!x.checkLeaf) {
//                for (Node item : x.keys) {
//                    System.out.println(item.values);
//                    lst.add(item);
//                    level.add(lev + 1);
//                }
//            } else {
//                for (Node item : x.keys) {
//                    System.out.println(item.values);
//                    lst.add(item);
//                    level.add(lev + 1);
//                }
//                if (flag == 0) {
//                    lev_leaf = lev;
//                    leaf = x;
//                    flag = 1;
//                }
//            }
//        }
//    }
//}
//
//=======
//>>>>>>> b3c3d15b34c41577abf2aeca465cc710b74ad10d
