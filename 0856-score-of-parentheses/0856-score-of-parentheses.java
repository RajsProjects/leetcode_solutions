class Solution {
    public int scoreOfParentheses(String s) {
        int balance = 0;
        int score = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                balance++;
            }else{
                balance--;
                if(s.charAt(i - 1) == '('){
                    score += 1 << balance;
                }
            }
        }
        return score;
    }
}