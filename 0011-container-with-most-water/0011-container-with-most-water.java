class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        
        int left = 0;
        int right = height.length - 1;

        while(left < right){
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int area = currentHeight * currentWidth;

            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}