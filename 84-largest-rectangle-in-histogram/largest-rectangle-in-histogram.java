class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;

        int[] prev = new int[n];
        int[] next = new int[n];

        int max = 0;
        int width = 0;
        int area = 0;

        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            next[i] = stack.isEmpty()? n : stack.peek();

            stack.push(i);
        }

        stack.clear();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            prev[i] = stack.isEmpty()? -1 : stack.peek();

            stack.push(i);

            width = next[i] - prev[i] - 1;
            area = heights[i] * width;
            max = Math.max(max, area);
        }
    return max;
    }
}