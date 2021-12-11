package algorithms.level4BFS;

public class MyQueue {
    public Node head, tail;

    public MyQueue() {
        head = tail = null;
    }
    /*
     * @param item: An integer
     * @return: nothing
     */
    public void enqueue(int item) {
        if (head == null) {
            tail = new Node(item);
            head = tail;
        }
        else {
            tail.next = new Node(item);
            tail = tail.next;
        }
    }
    /*
     * @return: An integer
     */
    public int dequeue() {
        if (head != null) {
            int item = head.value;
            head = head.next;
            return item;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}

class Node {
    public int value;
    public Node next;

    public Node (int item) {
        this.value = item;
        this.next = null;
    }
}
