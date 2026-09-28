class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int max = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(ch);
                count++;
                max = Math.max(max, count);
            }
            else if(ch == ')'){
                stack.pop();
                count--;
            }
        }
        return max;
    }
}