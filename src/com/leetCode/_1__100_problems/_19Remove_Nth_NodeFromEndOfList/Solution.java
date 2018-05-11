package com.leetCode._1__100_problems._19Remove_Nth_NodeFromEndOfList;



class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return  null;
        int i=0;
        ListNode runner =head;
        while (runner!=null && i<n){
            runner = runner.next;
            i++;
        }
        if(i<n)
            return  head;
        if(runner == null)
            return  head.next;
        ListNode walker =head;
        while (runner.next != null){
            walker = walker.next;
            runner = runner.next;
        }
        walker.next = walker.next.next;
        return head;
    }


    public static void  main(String[] args){

       ListNode ls = new ListNode(1);
       ls.next = new ListNode(2);
       ls.next.next = new ListNode(3);
       ls.next.next.next = new ListNode(4);
       ls.next.next.next.next = new ListNode(5);
        System.out.println("result: "+new Solution().removeNthFromEnd(ls,2));

    }

}
