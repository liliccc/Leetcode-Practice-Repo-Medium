package algorithms.level14DataStructuresReview;

import java.util.Stack;

public class MyQueue {
    //  Problem name: Implement Queue by Two Stacks
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }
    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        stack1.push(element);
    }

    private void moveFromStack1ToStack2() {
        while (!stack1.isEmpty()) {
            int element = stack1.pop();
            stack2.push(element);
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if (stack2.isEmpty()) {
            moveFromStack1ToStack2();
        }
        return stack2.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        if (stack2.isEmpty()) {
            moveFromStack1ToStack2();
        }
        return stack2.peek();
    }
}
