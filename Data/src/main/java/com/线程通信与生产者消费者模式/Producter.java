package com.线程通信与生产者消费者模式;

/**
 * @author 一笑奈何
 * @create 2019-01-02 10:19
 * @desc 生产者
 **/

public class Producter implements Runnable {
    int x=0;

    private Student student;
    public Producter(Student student) {
        this.student=student;
    }

    @Override
    public void run() {
        //判断是否已经有,如果生产了就等待,第一次进来还没有生产就不等待,生产完了唤醒消费的线程
        for (int i=0;i<30;i++){

            synchronized (student){
                if (student.flag){
                    try {
                        student.wait();    //等待并释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (x%2==0){
                    student.name="徐邵利";
                    student.age=27;
                }else {
                    student.name="李朋";
                    student.age=22;
                }
                x++;
                student.flag=true;
                student.notify();

            }

        }
    }
}
