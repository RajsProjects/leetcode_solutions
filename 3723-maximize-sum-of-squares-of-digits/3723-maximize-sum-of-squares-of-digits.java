class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(num * 9 < sum){
            return "";
        }

        int digit = sum / 9;
        sum %= 9;
        StringBuilder score = new StringBuilder("9".repeat(digit));

        if(sum > 0){
            score.append(sum);
        }
        score.append("0".repeat(num - score.length()));

        return score.toString();
    }
}