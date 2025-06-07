package medium;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find the length of the list
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Make the list circular
        current.next = head;

        // Calculate the effective rotations needed
        k = k % length;
        if (k == 0) {
            current.next = null; // Break the circular link
            return head;
        }

        // Find the new tail: (length - k - 1)th node
        int newTailIndex = length - k - 1;
        ListNode newTail = head;
        for (int i = 0; i < newTailIndex; i++) {
            newTail = newTail.next;
        }

        // Set the new head and break the circular link
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        RotateList solution = new RotateList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        ListNode rotatedHead = solution.rotateRight(head, k);

        // Print the rotated list
        ListNode current = rotatedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

}
