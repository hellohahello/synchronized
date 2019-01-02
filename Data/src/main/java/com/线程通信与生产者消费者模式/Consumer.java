package com.线程通信与生产者消费者模式;

/**
 * @author 一笑奈何
 * @create 2019-01-02 10:20
 * @desc 消费者
 **/

public class Consumer implements Runnable {
    private Student student;
    boolean flag;
    public Consumer(Student student) {
        this.student=student;
    }

    @Override
    public void run() {
        //两个线程同一把锁
        for (int i=0;i<30;i++){
//            消费者第一次进入等待

       synchronized (student){
           if (!student.flag){
               try {
                   student.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
               System.out.println(student.name+"*****"+student.age);
          student. flag=false;
           student.notify();
           }
           //消费完了唤醒

       }
    }
}
