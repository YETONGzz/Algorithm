package com.yetong.algorithm.Title100.Title30;

public class No21mergeTwoLists {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                result.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                result.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            result = result.next;
        }
        result.next = (list1 == null) ? list2 : list1;
        return result.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
