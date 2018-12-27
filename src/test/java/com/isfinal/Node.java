package com.isfinal;

/**
 * Created by wjb on 2018/12/20.
 */
public class Node {

    public Node next;

    public int data;

    public Node(int data){
        this.data = data;
    }

    public Node(Node next, int data) {
        this.next = next;
        this.data = data;
    }
}
