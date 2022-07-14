package com.zwan.algorithm.class03;

import java.util.Stack;

/**
 * @author zwan
 * Create by zwan on 2022/7/6 23:27
 */
public class Code06_TwoStacksImplementQueue {

    public static class TwoStacksQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPop = new Stack<>();
            stackPush = new Stack<>();
        }

        private void pushToPop() {
            if (stackPop.empty()) {
                // 只有在pop栈为空时将push栈存入pop栈
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        private void add(int value){
            stackPush.push(value);
            pushToPop();
        }

        private int poll(){
            pushToPop();
            if (stackPop.isEmpty()){
                throw new RuntimeException("队列已空");
            }
            return stackPop.pop();
        }

        private int peek(){
            pushToPop();
            if (stackPop.isEmpty()){
                throw new RuntimeException("队列已空");
            }
            return stackPop.peek();
        }

        public static void main(String[] args) {
            TwoStacksQueue test = new TwoStacksQueue();
            test.add(1);
            test.add(2);
            test.add(3);
            System.out.println(test.peek());
            System.out.println(test.poll());
            System.out.println(test.peek());
            System.out.println(test.poll());
            System.out.println(test.peek());
            System.out.println(test.poll());
        }

    }
}
