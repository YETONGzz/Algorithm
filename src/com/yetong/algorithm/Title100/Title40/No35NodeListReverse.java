package com.yetong.algorithm.Title100.Title40;



/**
 * 删除倒数第n个链表节点
 */
public class No35NodeListReverse {

    public static void main(String[] args) {
        ListNode1 listNode = new ListNode1(0);
        No35NodeListReverse no35SolveSudoku = new No35NodeListReverse();
        no35SolveSudoku.test(listNode);
        for (int i = 0;i < 10;i++){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public void solveSudoku(char[][] board) {

        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k < 9; k++) {
                        if (row[i][('0' + 1) - '0'] != 1) {
                            return;
                        }
                    }
                    continue;
                }
                if (row[i][board[i][j] - '0'] == 1) {
                    return;
                }
                row[i][board[i][j]] = 1;

                if (col[j][board[i][j]] == 1) {
                    return;
                }
                col[j][board[i][j]] = 1;

                if (box[j / 3 + (i / 3) * 3][board[i][j]] == 1) {
                    return;
                }
                box[j / 3 + (i / 3) * 3][board[i][j]] = 1;

            }
        }
        return;
    }

    public void test(ListNode1 listNode1){
        ListNode1 temp = new ListNode1(-1);
        for (int i = 0;i < 10;i++){
            ListNode1 listNode11 = new ListNode1(i + 2);
            if(i==0){
                listNode1.next = listNode11;
            }else temp.next = listNode11;

            temp = listNode11;
        }
    }

   /* public ListNode1 removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while(n != 0) {
            start = start.next;
            n--;
        }
        while(start.next != null) {

            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }*/


}

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int x) {
        val = x;
    }
}
