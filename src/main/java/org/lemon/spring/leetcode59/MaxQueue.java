package org.lemon.spring.leetcode59;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月07日 06:20:00
 */
public class MaxQueue {

    Queue<Integer> queue;
    Deque<Integer> maxQueue;

    public MaxQueue() {
        queue = new ArrayDeque<>();
        maxQueue = new ArrayDeque<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty()) {
            return -1;
        }
        return maxQueue.peek();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!maxQueue.isEmpty() && value > maxQueue.getLast()) {
            maxQueue.pollLast();
        }
        maxQueue.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int res = queue.poll();
        if (res == maxQueue.peek()) {
            maxQueue.poll();
        }
        return res;
    }

}
