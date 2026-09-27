class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // Phase 1: Create and interleave copies
        Node current = head;

        while (current != null) {
            Node copyNode = new Node(current.val);

            copyNode.next = current.next;
            current.next = copyNode;

            current = copyNode.next;
        }

        // Phase 2: Set random pointers
        current = head;

        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }

            current = current.next.next;
        }

        // Phase 3: Separate original and copied lists
        current = head;
        Node copyHead = head.next;

        while (current != null) {
            Node copy = current.next;

            current.next = copy.next;

            if (copy.next != null) {
                copy.next = copy.next.next;
            }

            current = current.next;
        }

        return copyHead;
    }
}