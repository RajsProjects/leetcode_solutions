class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] prev = new int[n];
        int[] next = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        // Next Smaller Element (Right -> Left)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Previous Smaller Element (Left -> Right)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int maxArea = 0;

        // Calculate maximum area
        for (int i = 0; i < n; i++) {
            int width = next[i] - prev[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}