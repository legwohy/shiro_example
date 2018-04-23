package com.myLinked.util;

/**
 * 节点
 */
public class Node<T> {
    T data;// 数据
     Node<T> prev;// 上一个
     Node<T> next;// 下一个
    public Node(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public Node<T> getNext() {
        return next;
    }
}
