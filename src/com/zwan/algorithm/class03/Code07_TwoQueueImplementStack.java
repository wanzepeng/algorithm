package com.zwan.algorithm.class03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zwan
 * Create by zwan on 2022/7/7 4:40
 */
public class Code07_TwoQueueImplementStack {

    public static class TwoQueueStack<T> {
        public Queue<T> queue;
        public Queue<T> help;

        public TwoQueueStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(T value) {
            queue.offer(value);
        }

        public T poll() {
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            T value = queue.poll();

            Queue<T> tmp = help;
            help = queue;
            queue = tmp;
            return value;
        }

        public T peek() {
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            T value = queue.poll();
            help.add(value);
            Queue<T> tmp = help;
            help = queue;
            queue = tmp;
            return value;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
    public static void main(String[] args) {
        System.out.println("test begin");
        TwoQueueStack<Integer> myStack = new TwoQueueStack<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 1000000;
        int max = 1000000;
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty()) {
                if (!test.isEmpty()) {
                    System.out.println("Oops");
                }
                int num = (int) (Math.random() * max);
                myStack.push(num);
                test.push(num);
            } else {
                if (Math.random() < 0.25) {
                    int num = (int) (Math.random() * max);
                    myStack.push(num);
                    test.push(num);
                } else if (Math.random() < 0.5) {
                    if (!myStack.peek().equals(test.peek())) {
                        System.out.println("Oops");
                    }
                } else if (Math.random() < 0.75) {
                    if (!myStack.poll().equals(test.pop())) {
                        System.out.println("Oops");
                    }
                } else {
                    if (myStack.isEmpty() != test.isEmpty()) {
                        System.out.println("Oops");
                    }
                }
            }
        }

        System.out.println("test finish!");

    }

}
