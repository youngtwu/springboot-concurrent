package com.github.youngtwu.springbootconcurrent.ThreadDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 在编写多线程的工作中，有个常见的问题：主线程（main) 启动好几个子线程（task）来完成并发任务，主线程要等待所有的子线程完成之后才继续执行main的其它任务。
 * 默认主线程退出时其它子线程不会停，如果想让main退出时其它子线程终止，可以用subThread.setDaemon(true) 设置子线程为“守护线程”。
 * 如果要在主线程等待所有子线程完成后，还要执行其它操作（比如：结果合并）.可以用join()方法来等待所有子线程完成后，才继续执行
 */
public class TestRunnable implements Runnable{
    /** 线程名 */
    private String threadName;


    public TestRunnable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println( "[" + threadName + "] Running !" );
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> lists = new ArrayList<Thread>();
        for(int i=0; i<5; i++){
            Thread thread = new Thread(new TestRunnable("子线程" + (i + 100)));
            lists.add(thread);
            thread.start();
        }
        System.out.println("主线程阻塞,等待所有子线程执行完成");
        for(Thread thread : lists){
            // 如果注释掉thread.join(),启动后 main线程 与 所有子线程 thread并发工作,并不会等待子线程完成后再执行
            thread.join();
        }
        System.out.println("所有线程执行完成!");
    }
}
