class Solution {
    public int minAddToMakeValid(String s) {
        int balance = 0;
        int needed = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                balance++;
            }else{
                balance--;
                if(balance < 0){
                    needed++;
                    balance++;
                }
            }
        }

        return balance + needed;
    }
}