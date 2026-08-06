class Solution {
    public int maximalRectangle(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length; 

        int[] heights = new int[cols];
        int answer = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                }else{
                    heights[j] = 0;
                }
            }

            answer = Math.max(answer, largestRectangleArea(heights));
        }

        return answer;
    }

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