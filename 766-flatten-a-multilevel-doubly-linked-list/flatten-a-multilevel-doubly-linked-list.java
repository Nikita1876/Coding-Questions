
class Solution {
    public Node flatten(Node head) {

        if (head == null) {
            return head;
        }

        Node curr = head;

        while (curr != null) {

            if (curr.child == null) {
                curr = curr.next;
            }
            else {

                Node fwd = curr.next;

                // Flatten the child list
                Node c = flatten(curr.child);

                // Connect current node to child
                curr.next = c;
                c.prev = curr;

                // Find the tail of child list
                Node temp = c;

                while (temp.next != null) {
                    temp = temp.next;
                }

                // Connect child tail to original next
                temp.next = fwd;

                if (fwd != null) {
                    fwd.prev = temp;
                }

                // Remove child pointer
                curr.child = null;

                // Continue traversal
                curr = curr.next;
            }
        }

        return head;
    }
}
