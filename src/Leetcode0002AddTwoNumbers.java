public class Leetcode0002AddTwoNumbers {
    //dummy Node is useful when u cannot make sure the head
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            int sum = carry;
            sum += l1 == null ? 0 : l1.val;
            sum += l2 == null ? 0 : l2.val;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1 == null? l1 : l1.next;
            l2 = l2 == null? l2 : l2.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }
    //Definition for singly-linked list in leetcode
    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
}
