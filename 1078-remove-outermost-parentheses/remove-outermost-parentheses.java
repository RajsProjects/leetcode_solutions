class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder string = new StringBuilder();
        int balance = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(balance > 0){
                    string.append(ch);
                }
                balance++;

            }else{
                balance--;

                if(balance > 0){
                    string.append(ch);
                }
            }
        }
        return string.toString();
    }
}