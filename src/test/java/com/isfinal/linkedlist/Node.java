package com.isfinal.linkedlist;

/**
 * Created by wjb on 2019/3/15.
 */
public class Node<E> {

    public E item;

    Node<E> prev;

    Node<E> next;

    public Node(){}

    public  Node (Node<E> prev,Node<E> next,E item){
        this.prev=prev;
        this.next=next;
        this.item=item;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
