package com.leecode.dto;

//每一个链表实际上就是由多个节点组成的
public class Node {
    public static String data; //用于保存数据
    public static Node next;   //用于保存下一个节点

    public Node(String data) {  //每一个Node类对象都必须保存有数据
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }

    public String getData() {
        return this.data;
    }
}
