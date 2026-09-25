class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i <= n; i++){
            int current = (i == n) ? 0 : heights[i];

            while(!stack.isEmpty() && current <= heights[stack.peek()]){
                int top = stack.pop();

                int height = heights[top];

                int prev = stack.isEmpty() ? -1 : stack.peek();

                int next = i;

                int width = next - prev - 1;

                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}