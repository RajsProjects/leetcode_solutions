class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder score = new StringBuilder("");

        if(num * 9 < sum || sum < 1){
            return "";
        }

        for(int i = 0; i < num; i++){
            int digit = Math.min(9, sum);
            sum -= digit;
            score.append(digit);
        }

        return score.toString();
    }
}