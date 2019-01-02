package com.线程通信与生产者消费者模式;

/**
 * @author 一笑奈何
 * @create 2019-01-02 10:19
 * @desc
 **/

public class App {
    public static void main(String[] args) {
        Student student=new Student();
        Producter producter=new Producter(student);
        Consumer consumer=new Consumer(student);
        Thread t1=new Thread(consumer);
        Thread t2=new Thread(producter);
        t2.start();
        t1.start();
    }
}
