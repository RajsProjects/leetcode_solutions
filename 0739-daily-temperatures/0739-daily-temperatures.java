class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }

            if(stack.isEmpty()){
                answer[i] = 0;
            }else{
                answer[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return answer;
    }
}