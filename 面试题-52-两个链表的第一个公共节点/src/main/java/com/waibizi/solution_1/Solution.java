package com.waibizi.solution_1;

/**
 * @Author 歪鼻子
 * @Date 2020/9/3 2:48
 * @Description: 我们一人一步，如果我走到了尽头，
 *              我去你的起始位置去追寻你的痕迹，
 *              两个感情线互相交织，
 *              我相信，可以找到我们之前的共同点
 * @Version 1.0
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB){
            nodeA = nodeA == null? headB: nodeA.next;
            nodeB = nodeB == null? headA: nodeB.next;
        }
         return nodeA;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(8);
        int[] data = new int[]{1,8,4,5};
        ListNode headB = new ListNode(4);
        ListNode node = headB;

        for (int d:
             data) {

            node.next = new ListNode(d);
            node = node.next;

        }
        System.out.println(new Solution().getIntersectionNode(headA, headB).val);
    }
}

