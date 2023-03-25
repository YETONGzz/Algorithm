package com.yetong.algorithm.Title100.Title20;


/**
 * 删除链表的倒数第n个节点
 */
public class No19ListNodeFromEnd {
    int val;
    No19ListNodeFromEnd next;

    No19ListNodeFromEnd() {
    }

    No19ListNodeFromEnd(int val) {
        this.val = val;
    }

    No19ListNodeFromEnd(int val, No19ListNodeFromEnd next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public No19ListNodeFromEnd removeNthFromEnd(No19ListNodeFromEnd head, int n) {
        No19ListNodeFromEnd temp = head;
        int i = 1;
        while (temp.next != null) {
            temp = temp.next;
            i++;
        }
        int k = i - n;
        while (k > 0) {
            k--;
            head = head.next;
        }
        head.next = head.next.next;
        return head;
    }

    public No19ListNodeFromEnd removeNthFromEnd2(No19ListNodeFromEnd head, int n) {
        No19ListNodeFromEnd pre = head, end = head;
        while (n != 0) {
            pre = pre.next;
        }
        while (pre != null) {
            pre = pre.next;
            end = end.next;
        }
        end.next = end.next.next;

        return head;
    }

    public static void main(String[] args) {
        No19ListNodeFromEnd no19ListNodeFromEnd = new No19ListNodeFromEnd();
        no19ListNodeFromEnd.val = 0;
        No19ListNodeFromEnd no19ListNodeFromEnd2 = no19ListNodeFromEnd;
        for (int i = 1; i < 10; i++) {
            No19ListNodeFromEnd no19ListNodeFromEnd1 = new No19ListNodeFromEnd();
            no19ListNodeFromEnd1.val = i;
            no19ListNodeFromEnd.next = no19ListNodeFromEnd1;
            no19ListNodeFromEnd = no19ListNodeFromEnd.next;
        }

        while (no19ListNodeFromEnd2 != null) {
            System.out.println(no19ListNodeFromEnd2.val);
            no19ListNodeFromEnd2 = no19ListNodeFromEnd2.next;
        }
    }
}