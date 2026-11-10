class Solution {
    public ListNode removeNodes(ListNode head) {

        Stack<ListNode> st = new Stack<>();

        ListNode temp = head;

        // Step 1: Traverse the linked list
        while (temp != null) {

            while (!st.isEmpty() && st.peek().val < temp.val) {
                st.pop();
            }

            st.push(temp);
            temp = temp.next;
        }

        // Step 2: Reconstruct linked list
        ListNode newHead = null;

        while (!st.isEmpty()) {

            ListNode top = st.pop();

            top.next = newHead;
            newHead = top;
        }

        return newHead;
    }
}
