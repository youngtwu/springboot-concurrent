package com.github.youngtwu.springbootconcurrent.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: wuyantao
 * @Date: 2018/11/3 15:55
 * @Description: CyclicBarrier初始化时规定一个数目，然后计算调用了CyclicBarrier.await()进入等待的线程数。
 * 当线程数达到了这个数目时，所有进入等待状态的线程被唤醒并继续。
 * CyclicBarrier就象它名字的意思一样，可看成是个障碍， 所有的线程必须到齐后才能一起通过这个障碍。
 * CyclicBarrier初始时还可带一个Runnable的参数， 此Runnable任务在CyclicBarrier的数目达到后，所有其它线程被唤醒前被执行。
 */
public class CyclicBarrierDemo extends Thread {
    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierDemo(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("线程" + Thread.currentThread().getName() + ",正在写入数据");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("线程" + Thread.currentThread().getName() + ",写入数据成功.....");

        try {
            cyclicBarrier.await();
        } catch (Exception e) {
        }
        System.out.println("所有线程执行完毕..........");
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo(cyclicBarrier);
            cyclicBarrierDemo.start();
        }
    }
}
