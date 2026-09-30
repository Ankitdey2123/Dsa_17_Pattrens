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
    public ListNode reverseList(ListNode head) {
        ListNode prv=null;
        ListNode current=head;
        while(current!=null ){
            ListNode next=current.next;
            current.next=prv;
            prv=current;
            current=next;
        }
        return prv;
    }
}