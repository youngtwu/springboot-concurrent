package com.github.youngtwu.springbootconcurrent.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Auther: wuyantao
 * @Date: 2018/11/6 17:26
 * @Description: LinkedBlockingQueue阻塞队列大小的配置是可选的，如果我们初始化时指定一个大小，它就是有边界的，如果不指定，它就是无边界的。
 * 说是无边界，其实是采用了默认大小为Integer.MAX_VALUE的容量 。它的内部实现是一个链表。
 * 和ArrayBlockingQueue一样，LinkedBlockingQueue 也是以先进先出的方式存储数据，最新插入的对象是尾部，最新移出的对象是头部
 */
public class LinkedBlockingQueueDemo {
    public static void main(String[] args) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(3);
        linkedBlockingQueue.add("张三");
        linkedBlockingQueue.add("李四");
        linkedBlockingQueue.add("李四");
        System.out.println(linkedBlockingQueue.size());

    }
}
