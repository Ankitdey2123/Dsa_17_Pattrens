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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;       // Position of first critical point
        int prevCritical = -1; // Position of previous critical point
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        ListNode prev = head;
        ListNode curr = head.next;

        int position = 1;

        while (curr != null && curr.next != null) {
            ListNode next = curr.next;

            // Check if current node is a local maximum or minimum
            boolean isMax = curr.val > prev.val && curr.val > next.val;
            boolean isMin = curr.val < prev.val && curr.val < next.val;

            if (isMax || isMin) {
                // First critical point
                if (first == -1) {
                    first = position;
                }

                // Calculate distance from previous critical point
                if (prevCritical != -1) {
                    int distance = position - prevCritical;
                    minDistance = Math.min(minDistance, distance);
                }

                prevCritical = position;

                // Distance between first and current critical point
                maxDistance = position - first;
            }

            prev = curr;
            curr = next;
            position++;
        }

        // Fewer than two critical points
        if (minDistance == Integer.MAX_VALUE) {
            return new int[] {-1, -1};
        }

        return new int[] {minDistance, maxDistance};
    }
}