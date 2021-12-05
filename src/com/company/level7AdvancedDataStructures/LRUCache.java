package com.company.level7AdvancedDataStructures;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private LinkedNode dummy, tail;
    private Map<Integer, LinkedNode> keyToPrev;

    /*
     * @param capacity: An integer
     */public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dummy = new LinkedNode(0, 0, null);
        this.tail = this.dummy;
        this.keyToPrev = new HashMap<>();
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }
        LinkedNode prev = keyToPrev.get(key);
        LinkedNode current = prev.next;
        // move back prev
        moveToBack(prev);
        return current.value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        if (keyToPrev.containsKey(key)) {
            // move prev back
            LinkedNode prev = keyToPrev.get(key);
            moveToBack(prev);
            tail.value = value;
            return;
        }
        LinkedNode current = new LinkedNode(key, value, null);
        pushNewToBack(current);
        if (keyToPrev.size() > capacity) {
            deleteHead();
        }
    }

    private void pushNewToBack(LinkedNode node) {
        // add first
        keyToPrev.put(node.key, tail);
        // cannot skip, tail.next = node must be added
        tail.next = node;
        tail = node;
        node.next = null;
    }

    private void deleteHead() {
        // delete first
        LinkedNode head = dummy.next;
        dummy.next= head.next;
        keyToPrev.remove(head.key);
        keyToPrev.put(head.next.key, dummy);
    }

    private void moveToBack(LinkedNode prev) {
        LinkedNode current = prev.next;
        if (current == tail) {
            return;
        }
        prev.next = current.next;
        keyToPrev.put(current.next.key, prev);
        pushNewToBack(current);
    }
}
