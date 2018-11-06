package com.github.youngtwu.springbootconcurrent.concurrent;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Auther: wuyantao
 * @Date: 2018/11/6 14:06
 * @Description: ConcurrentLinkedDeque : 是一个适用于高并发场景下的队列，通过无锁的方式，实现
 * 了高并发状态下的高性能，通常ConcurrentLinkedDeque性能好于BlockingQueue.它
 * 是一个基于链接节点的无界线程安全队列。该队列的元素遵循先进先出的原则。头是最先
 * 加入的，尾是最近加入的，该队列不允许null元素。
 * ConcurrentLinkedDeque重要方法:
 * add 和offer() 都是加入元素的方法(在ConcurrentLinkedQueue中这俩个方法没有任何区别)
 * poll() 和peek() 都是取头元素节点，区别在于前者会删除元素，后者不会。
 */
public class ConcurrentLinkedDequeDemo{

    public static void main(String[] args) {
        ConcurrentLinkedDeque q = new ConcurrentLinkedDeque();
        q.offer("余胜军");
        q.offer("码云");
        q.offer("蚂蚁课堂");
        q.offer("张杰");
        q.offer("艾姐");
        //从头获取元素,删除该元素
        System.out.println(q.poll());
        //从头获取元素,不刪除该元素
        System.out.println(q.peek());
        //获取总长度
        System.out.println(q.size());

    }
}
