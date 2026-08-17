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
    public ListNode deleteDuplicates(ListNode head) {

            if(head==null || head.next==null) return head;
            ListNode p=head;
            ListNode q=head.next;
            while(q!=null){
                if(p.val==q.val){
                    q=q.next;
                    if(q==null) p.next=null;
                }else{
                    p.next=q;
                    p=p.next;
                    q=q.next;
                    p.next=null;
                }
            }
            return head;
    }
}