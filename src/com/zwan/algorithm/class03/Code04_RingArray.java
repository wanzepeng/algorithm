package com.zwan.algorithm.class03;

import java.util.Queue;

/**
 * @author zwan
 * Create by zwan on 2022/7/6 13:40
 */
public class Code04_RingArray {
    public static class MyQueue {
        private int[] arr;
        private int pushi;// end
        private int polli;// begin
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            this.limit = limit;
            this.arr = new int[limit];
            this.polli = 0;
            this.pushi = 0;
            this.size = 0;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列已满");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int poll() {
            if (size == 0) {
                throw new RuntimeException("队列已空");
            }
            size--;
            int i = arr[polli];
            polli = nextIndex(polli);
            return i;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }
    }
}
