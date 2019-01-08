package com.isfinal;

/**
 * Created by wjb on 2018/11/4.
 */
public class LinkTest {

    private Node head;
    public LinkTest(){
        this.head = new Node(20);
    }

    /**
     * 添加节点
     *
     * @param value
     */
    public  void addData(int value) {
        Node newNode = new Node(value);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void traverse(Node head){
        Node temp = head.next;
        while (temp != null){
            System.out.println("==="+temp.data);
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        LinkTest linkTest = new LinkTest();
        linkTest.addData(1);
        linkTest.addData(5);
        linkTest.addData(6);
        linkTest.addData(3);
        linkTest.addData(2);

        linkTest.traverse(linkTest.head);

    }


}
