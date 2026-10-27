class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = n - 1; i >= 0; i--){
            int current = temperatures[i];

            while(!stack.isEmpty() && current >= temperatures[stack.peek()]){
                stack.pop();
            }

            if(stack.isEmpty()){
                result[i] = 0;
            }else{
                result[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return result;
    }
}