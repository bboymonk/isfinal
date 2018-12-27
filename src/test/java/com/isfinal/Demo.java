package com.isfinal;

/**
 * Created by wjb on 2018/11/4.
 */
public class Demo {

    private Node head;
    public Demo(){
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
        Demo demo = new Demo();
        demo.addData(1);
        demo.addData(5);
        demo.addData(6);
        demo.addData(3);
        demo.addData(2);

        demo.traverse(demo.head);

    }


}
