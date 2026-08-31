class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int firstCritical = -1;
        int previousCritical = -1;

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;

        while (curr.next != null) {

            int prevValue = prev.val;
            int currValue = curr.val;
            int nextValue = curr.next.val;

            // Check whether current node is a critical point
            boolean isCritical =
                    (currValue > prevValue && currValue > nextValue) ||
                    (currValue < prevValue && currValue < nextValue);

            if (isCritical) {

                // First critical point
                if (firstCritical == -1) {
                    firstCritical = index;
                }

                // We already found a previous critical point
                if (previousCritical != -1) {
                    minDistance = Math.min(
                            minDistance,
                            index - previousCritical
                    );
                }

                previousCritical = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // Fewer than two critical points
        if (firstCritical == previousCritical) {
            return new int[]{-1, -1};
        }

        maxDistance = previousCritical - firstCritical;

        return new int[]{minDistance, maxDistance};
    }
}