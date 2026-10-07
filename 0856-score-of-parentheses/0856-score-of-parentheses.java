class Solution {
    public int scoreOfParentheses(String s) {
        int jobOffer = 0;
        int rejection = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                jobOffer++;
            }else{
                jobOffer--;
                if(s.charAt(i - 1) == '('){
                    rejection += 1 << jobOffer;
                }
            }
        }
        return rejection;
    }
}