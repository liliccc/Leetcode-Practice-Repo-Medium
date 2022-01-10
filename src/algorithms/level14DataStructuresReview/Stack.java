package algorithms.level14DataStructuresReview;

import java.util.LinkedList;
import java.util.Queue;

public class Stack {
    // problem name: 494 · Implement Stack by Two Queues
    /*
     * @param x: An integer
     * @return: nothing
     */
    Queue<Integer> queue1, queue2;
    public Stack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    private void moveToQueue2() {
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
    }
    private void swapTwoQueues() {
        Queue<Integer> temp = new LinkedList<>();
        temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public void push(int x) {
        queue1.offer(x);
    }

    /*
     * @return: nothing
     */
    public int pop() {
        moveToQueue2();
        int item = queue1.poll();
        swapTwoQueues();
        return item;
    }

    /*
     * @return: An integer
     */
    public int top() {
        int item = pop();
        queue1.offer(item);
        return item;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}
