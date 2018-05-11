package com.leetCode._1__100_problems._24SwapNodesInPairs;

public class Solution {

    public ListNode swapPairs(ListNode head) {
        int preVal;
        ListNode  preNode = head;
        while(head != null && head.next !=null){
            preVal = head.val;
            head.val = head.next.val;
            head.next.val = preVal;
            head = head.next.next;
        }

        return preNode;
    }

    public static void  main(String[] args){

        ListNode lft = new ListNode(1);
        lft.next = new ListNode(2);
        lft.next.next = new ListNode(3);
      //  lft.next.next.next = new ListNode(4);



        System.out.println("result: "+new Solution().swapPairs(lft));

    }
}
