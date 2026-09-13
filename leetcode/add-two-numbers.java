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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode lastNode = answer;

        int carry = 0;

        while(l1 != null || l2 != null) {
            int firstNumber = 0;
            int secondNumber = 0;

            if(l1 != null) {
                firstNumber = l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                secondNumber = l2.val;
                l2 = l2.next;
            }

            int sum = firstNumber + secondNumber + carry;

            int currentNumber = sum % 10;
            carry = sum / 10;

            lastNode.next = new ListNode(currentNumber);
            lastNode = lastNode.next;
        }

        if(carry != 0) {
            lastNode.next = new ListNode(carry);
        }

        return answer.next;
    }
}
