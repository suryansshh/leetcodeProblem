/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null , next = null , curr= head;
        int count = k;
        while(curr!=null && count>0){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr = next;
            count--;
        }
        if(curr==null && count>0){
            curr = prev;
            prev = null ; next = null;
             while(curr!=null && count>0){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr = next;
        }
        }
        if(count>0){
            return prev;
        }
        head.next = reverseKGroup(curr ,k );
        return prev;
    }
}