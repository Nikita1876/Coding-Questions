
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] ans = {-1, -1};

        if (head == null || head.next == null || head.next.next == null) {
            return ans;
        }

        int idx = 1;
        int firstidx = -1;
        int lastidx = -1;
        int minDist = Integer.MAX_VALUE;

        ListNode a = head;
        ListNode b = a.next;
        ListNode c = b.next;

        while (c != null) {

            // Check whether b is a critical point
            if ((b.val > a.val && b.val > c.val) ||
                (b.val < a.val && b.val < c.val)) {

                if (firstidx == -1) {
                    firstidx = idx;
                }

                if (lastidx != -1) {
                    int dist = idx - lastidx;
                    minDist = Math.min(dist, minDist);
                }

                lastidx = idx;
            }

            idx++;
            a = a.next;
            b = b.next;
            c = c.next;
        }

        // At least two critical points required
        if (firstidx == lastidx) {
            return ans;
        }

        int maxDist = lastidx - firstidx;

        ans[0] = minDist;
        ans[1] = maxDist;

        return ans;
    }
}
