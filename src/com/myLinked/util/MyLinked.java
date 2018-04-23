package com.myLinked.util;

/**
 *
 */
public class MyLinked<T> {

    Node<T> head;
    Node<T> tail;
    private int size = 0;

    /**
     * 插尾
     * @param data
     */
    public void insertByTail(T data){
        if(null != data){
            Node<T> current = new Node<>(data);
            if(null == head){
                head = current;
                tail = current;
                size = 0;
            }else {
                Node<T> old = tail;
                tail.next = current;
                tail = tail.next;
                tail.prev = old;
                size ++;
            }
        }
    }

    /**
     * 指定位置插入
     * @param index
     * @param data
     */
    public void insertByIndex(int index,T data){
        // 插头
        if(index == 0){
            Node<T> current = query(index);// 插的位置
            head = new Node<>(data);
            head.next = current;
        }else if(index > size){

            // 插尾
            Node<T> current = query(size);
            tail = new Node<>(data);
            tail.prev = current;

        }else {
            Node<T> current = query(index);
            Node<T> newNode = new Node<>(data);

            // 新节点前后重新指向
            newNode.next = current;
            newNode.prev = current.prev;

            // 前断节点重新指向
            current.prev = newNode;

            // 后断节点
            current.prev.next = newNode;

        }
        size ++;

    }

    /**
     * 去头
     */
    public void removeHead(){
        Node<T> current = head.next;
        if(null != current){
            head = current;
            head.next = current.next;
            size --;
        }

    }

    /**
     * 索引查询
     * @return index
     */
    public Node<T> query(int index){
        Node<T> current = head;

        for (int i = 0;i < index;i++){
            current = current.next;
        }
        return current;

    }

    public T getFirst(){
        return head.data;
    }

    public T getLast(){
        return tail.data;
    }

    public int getSize() {
        return size;
    }

    public int length(){
        if(size == 0){
            return 0;
        }
        return size ++;
    }




}
