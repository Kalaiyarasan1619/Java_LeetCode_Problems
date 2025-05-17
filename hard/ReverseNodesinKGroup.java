package hard;

public class ReverseNodesinKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEnd = prevGroupEnd;

            for (int i = 0; i < k; i++) {
                groupEnd = groupEnd.next;
                if (groupEnd == null) {
                    return dummy.next;
                }
            }

            ListNode nextGroupStart = groupEnd.next;
            groupEnd.next = null;

            prevGroupEnd.next = reverseList(groupStart);
            groupStart.next = nextGroupStart;

            prevGroupEnd = groupStart;
        }

    }

    // Helper method to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseNodesinKGroup solution = new ReverseNodesinKGroup();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 2;
        ListNode result = solution.reverseKGroup(head, k);
        printList(result);
    }

    // Utility method to print the linked list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
