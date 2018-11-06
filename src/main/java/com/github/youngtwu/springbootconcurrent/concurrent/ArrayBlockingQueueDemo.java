package com.github.youngtwu.springbootconcurrent.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: wuyantao
 * @Date: 2018/11/6 14:49
 * @Description: ArrayBlockingQueue是一个有边界的阻塞队列，它的内部实现是一个数组。有边界的意思是它的容量是有限的，
 * 我们必须在其初始化的时候指定它的容量大小，容量大小一旦指定就不可改变。
 * ArrayBlockingQueue是以先进先出的方式存储数据，最新插入的对象是尾部，最新移出的对象是头部
 */
public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> arrays = new ArrayBlockingQueue<String>(3);
        arrays.add("李四");
        arrays.add("张军");
        arrays.add("张军");
        try {
            // 添加阻塞队列
            arrays.offer("张三", 1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(arrays);
    }
}
