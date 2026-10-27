class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        int[] stack = new int[n];
        int sp = -1;

        for(int i = 0; i <= n; i++){
            int current = (i == n) ? 0 : heights[i];

            while(sp >= 0 && heights[stack[sp]] > current){
                int height = heights[stack[sp--]];
                int width = sp < 0 ? i : i - stack[sp] - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            if(i < n) stack[++sp] = i;
        }

        return maxArea;
    }
}