package algorithms.level14DataStructuresReview;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack, minStack;
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty() || number <= minStack.peek()) {
            minStack.push(number);
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        int number = stack.pop();
        if (minStack.peek() == number) {
            minStack.pop();
        }
        return number;
    }

    /*
     * @return: An integer
     */
    public int min() {
        return minStack.peek();
    }
}
