package com.company.level7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqueNumberinDataStream {
    /**
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
    public static int firstUniqueNumber(int[] nums, int number) {
        DataStream ds = new DataStream();
        for (int i = 0; i < nums.length; i++) {
            ds.add(nums[i]);
            if (nums[i] == number) {
                return ds.findUniqueValue();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,1,2,4,4,5,6,5,7,6,8};
        int num = 8;
        System.out.println(firstUniqueNumber(nums, num));
    }

}

class DataStream {

    private ListNode dummy, tail;
    private Map<Integer, ListNode> uniqueMap;
    private Set<Integer> duplicates;

    public DataStream() {
        this.dummy = new ListNode(0);
        this.tail = dummy;
        this.uniqueMap = new HashMap();
        this.duplicates = new HashSet<>();
    }

    public void add(int num) {
        // duplicates check must be first
        if (duplicates.contains(num)) {
            return;
        }
        if (!uniqueMap.containsKey(num)) {
            pushBack(num);
            return;
        }
        duplicates.add(num);
        remove(num);
    }

    public int findUniqueValue() {
        if (dummy.next == null) {
            return -1;
        }
        return dummy.next.val;
    }

    public void pushBack(int num) {
        ListNode newNode = new ListNode(num);
        tail.next = newNode;
        uniqueMap.put(num, tail);
        tail = newNode;
        newNode.next = null;
    }

    public void remove(int num) {
        ListNode prev = uniqueMap.get(num);
        ListNode current = prev.next;
        prev.next = current.next;
        uniqueMap.remove(num);
        if (prev.next != null) {
            uniqueMap.put(prev.next.val, prev);
        }
        else {
            tail = prev;
        }

    }
}
