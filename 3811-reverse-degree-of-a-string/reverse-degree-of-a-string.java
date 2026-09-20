class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int sum = 0;

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            int mul = (i + 1) * (26 - (c - 'a'));
            sum += mul;
        }
        return sum;
    }
}