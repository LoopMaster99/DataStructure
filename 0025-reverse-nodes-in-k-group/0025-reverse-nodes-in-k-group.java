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
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    private ListNode kthFind(ListNode temp, int k){
        k--;

        while(temp != null && k > 0){
            temp = temp.next;
            k--;
        }

        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head, next = null, prev = null;

        while(temp != null){
            ListNode kthNode = kthFind(temp, k);
            if(kthNode == null){
                if(prev != null) prev.next = temp;
                break;
            }

            next = kthNode.next;
            kthNode.next = null;

            ListNode newHead = reverse(temp);

            if(temp == head){
                head = newHead;
            }
            else{
                prev.next = kthNode;
            }

            prev = temp;
            temp = next;
        }

        return head;
    }
}