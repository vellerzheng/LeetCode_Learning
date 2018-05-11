package com.leetCode._1__100_problems._23Merge_K_SortedLists;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length ==0)
            return  null;
        if(lists.length ==1)
            return lists[0];

        ListNode result = lists[0];
        for(int i=1;i<lists.length;i++){
            result =mergeTwoLists(result,lists[i]);
        }
        return result;
    }

    /**
     * 利用分治的思想把合并k个链表分成两个合并k/2个链表的任务，一直划分，知道任务中只剩一个链表或者两个链表。
     * 可以很简单的用递归来实现。因此算法复杂度为T(k) = 2T(k/2) + O(nk),很简单可以推导得到算法复杂度为O（nklogk）
     * 下面是非递归的代码非递归的思想是（以四个链表为例）：
           1、3合并，合并结果放到1的位置
           2、4合并，合并结果放到2的位置
           再把1、2合并（相当于原来的13 和 24合并）
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        int n = lists.length;
        if(n == 0)
            return  null;

        while (n > 1){
            int k = (n + 1)/2;
            for(int i= 0; i< n/2;i++)
                lists[i] = mergeTwoLists(lists[i],lists[i+k]);
            n= k;

        }
        return lists[0];
    }

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
        lft.next = new ListNode(4);
        lft.next.next = new ListNode(5);


        ListNode rgt = new ListNode(1);
        rgt.next = new ListNode(3);
        rgt.next.next = new ListNode(4);


        ListNode opt = new ListNode(2);
        opt.next = new ListNode(6);

        ListNode[] lists ={lft,rgt,opt};

        ListNode l1 = new ListNode(2);
        ListNode l2 = null;
        ListNode l3 = new ListNode(-1);

        ListNode[] lists1 = {l1,l2,l3};

        System.out.println("result: "+new Solution().mergeKLists1(lists));

    }
}
