package com.thread.service;

/**
 * 资源类
 */
public class Source {
    private  int capacity = 100;
    private int balance;// 剩余

    // 初始化容量
    public Source(int capacity){
        this.capacity = capacity;
        System.out.println("初始化容量"+capacity);
    }

    // 通常产量都不会超过容量
    public synchronized void produceBySyn(int i){
        // 生产不能超过容量
        if(balance < 0){
            try {
                wait();// 超过容量 阻塞生产
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();// 唤醒生产

        balance +=i;


        System.out.println("生产 "+Thread.currentThread().getName()+"\t增加:"+i+"\t余量:"+balance);
    }

    // 消费不能超过剩余
    public synchronized int consumeBySyn(int i){
        if(balance < 0){
            try {
                wait();// 阻塞消费
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();// 唤醒消费
        balance -= i;

        System.out.println("消费 "+Thread.currentThread().getName()+"\t减少:"+i+"\t余量:"+balance);
        return i;
    }


    //===================threadLocal共享变量=============================

    // 通常产量都不会超过容量
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    public  void produceByThreadLocal(int i){
        // 生产不能超过容量
        int value = threadLocal.get();
       /* if(value < 0){
            try {
                wait();// 超过容量 阻塞生产
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();// 唤醒生产*/

        value +=i;
        threadLocal.set(value);


        System.out.println("生产 "+Thread.currentThread().getName()+"\t增加:"+i+"\t余量:"+threadLocal.get());
    }

    // 消费不能超过剩余
    public  int consumeByThreadLocal(int i){
        int value = threadLocal.get();
       /* if(value < 0){
            try {
                wait();// 阻塞消费
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();// 唤醒消费*/
        value -= i;
        threadLocal.set(value);

        System.out.println("消费 "+Thread.currentThread().getName()+"\t减少:"+i+"\t余量:"+threadLocal.get());
        return i;
    }

}
