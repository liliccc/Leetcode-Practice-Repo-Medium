package algorithms.level14DataStructuresReview;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MaxStack {
    private Queue<Item> heap;
    private Stack<Item> stack;
    private HashSet<Item> removedSet;
    private int globalId;

    public MaxStack() {
        this.heap = new PriorityQueue<>();
        this.stack = new Stack<>();
        this.removedSet = new HashSet<>();
        this.globalId = 0;
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int x) {
        Item newItem = new Item(x, globalId);
        heap.offer(newItem);
        stack.push(newItem);
        globalId++;
    }

    private void clearStack() {
        while (!stack.isEmpty() && removedSet.contains(stack.peek())) {
            Item item = stack.pop();
            removedSet.remove(item);
        }
    }

    public int pop() {
        clearStack();
        Item item = stack.pop();
        removedSet.add(item);
        return item.val;
    }

    /*
     * @return: An integer
     */
    public int top() {
        clearStack();
        Item item = stack.peek();
        return item.val;
    }

    private void clearHeap() {
        while(!heap.isEmpty() && removedSet.contains(heap.peek())) {
            Item item = heap.poll();
            removedSet.remove(item);
        }
    }

    /*
     * @return: An integer
     */
    public int peekMax() {
        clearHeap();
        Item item = heap.peek();
        return item.val;
    }

    /*
     * @return: An integer
     */
    public int popMax() {
        clearHeap();
        Item item = heap.poll();
        removedSet.add(item);
        return item.val;
    }
}

class Item implements Comparable<Item>{
    int val, id;

    public Item(int val, int id) {
        this.val = val;
        this.id = id;
    }

    @Override
    public int compareTo(Item another) {
        if (this.val != another.val) {
            // from big to small
            return another.val - this.val;
        }
        return another.id - this.id;
    }
}

