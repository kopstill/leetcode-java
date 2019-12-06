package algorithms;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.junit.Assert;
import org.junit.Test;

/**
 * Add Two Numbers
 * 两数相加
 */
public class Problem2 {

    @Test
    public void testAddTwoNumbers() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(7);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(2);

        ListNode listNode = addTwoNumbers(l1, l2);
        Assert.assertEquals(3, listNode.val);
        Assert.assertEquals(2, listNode.next.val);
        Assert.assertEquals(2, listNode.next.next.val);
        Assert.assertEquals(1, listNode.next.next.next.val);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 2 -> 7 -> 3
        // 1 -> 5 -> 2
        // 372+251=623
        // 3 -> 2 -> 6
        // -----------
        // 2 -> 7 -> 9
        // 1 -> 5 -> 2
        // 972+251=1223
        // 3 -> 2 -> 2 -> 1

        ListNode result = new ListNode(0);
        ListNode temp = result;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;

            int sum = carry + x + y;
            carry = sum / 10;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return result.next;
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    private static class ListNode {

        @NonNull
        private int val;

        private ListNode next;

    }

}
