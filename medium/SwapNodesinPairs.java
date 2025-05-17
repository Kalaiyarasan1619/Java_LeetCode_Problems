package medium;

public class SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        ListNode prev = null;
        ListNode current = head;

        while (current != null && current.next != null) {
            ListNode nextPair = current.next.next;
            ListNode second = current.next;

            // Swap the pair
            second.next = current;
            current.next = nextPair;

            // Connect the previous pair to the current pair
            if (prev != null) {
                prev.next = second;
            }

            // Update the previous node to the first node of the swapped pair
            prev = current;

            // Move to the next pair
            current = nextPair;
        }

        return newHead;
    }

    // public static void main(String[] args) {
    // SwapNodesinPairs solution = new SwapNodesinPairs();

    // // Example usage

    // ListNode head = new ListNode(1);
    // head.next = new ListNode(2);
    // head.next.next = new ListNode(3);
    // head.next.next.next = new ListNode(4);
    // head.next.next.next.next = new ListNode(5);
    // ListNode result = solution.swapPairs(head);
    // // Print the result
    // while (result != null) {
    // System.out.print(result.val + " ");
    // result = result.next;
    // }
    // }

}
