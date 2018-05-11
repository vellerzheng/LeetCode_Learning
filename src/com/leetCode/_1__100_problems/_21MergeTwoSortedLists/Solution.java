package com.leetCode._1__100_problems._21MergeTwoSortedLists;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        // 创建一个head头，从后面开始接
        ListNode head=new ListNode(0);
        ListNode curr = head;
        //都不为空时
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next =l1;
                l1 =l1.next;
            }else {
                curr.next =l2;
                l2 = l2.next;
            }
            curr =curr.next;
        }

        //将l1或l2 剩下的拼接到curr指向的地址上
        if(l1 ==null){
            curr.next =l2;
        }
        if(l2 == null){
            curr.next = l1;
        }
        return head.next;
    }


    public static void  main(String[] args){

        ListNode lft = new ListNode(1);
        lft.next = new ListNode(2);
        lft.next.next = new ListNode(3);


        ListNode rgt = new ListNode(1);
        rgt.next = new ListNode(3);
        rgt.next.next = new ListNode(4);

        System.out.println("result: "+new Solution().mergeTwoLists(lft,rgt));

    }

}
