class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1){
            return false;
        }
        return isValid(0, ' ', s.toCharArray()) >= 0;
    }

    public int isValid(int i, char last, char[] s){
        if(i == s.length){
            return i;
        }
        if(i > s.length){
            return -1;
        }

        if(s[i] == '(' || s[i] == '[' || s[i] == '{'){
            int next = isValid(i + 1, s[i], s);
            return next < 0 ? -1 : isValid(next + 1, last, s);
        }

        if(s[i] == ')' && last == '('|| 
           s[i] == ']' && last == '['|| 
           s[i] == '}' && last == '{')
        {
            return i;
        }
        return -1;
    }
}