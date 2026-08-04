class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        // Notice i <= n (one extra iteration)
        for (int i = 0; i <= n; i++) {

            // Virtual bar of height 0 at the end
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] >= currentHeight) {

                // Bar whose rectangle is ending
                int top = stack.pop();

                int height = heights[top];

                // Previous Smaller Index
                int prev = stack.isEmpty() ? -1 : stack.peek();

                // Next Smaller Index
                int next = i;

                int width = next - prev - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}