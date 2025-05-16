package medium;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;

    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndofList solution = new RemoveNthNodeFromEndofList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2;
        ListNode result = solution.removeNthFromEnd(head, n);
        System.out.print("Result: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}
