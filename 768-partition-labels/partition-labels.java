class Solution {
    static{
        for(int i = 0; i < 500; i++) {
            partitionLabels("");
        }
    }
    public static List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        int[] lastOccurance = new int[26];

        for(int i = 0; i < s.length(); i++){
            lastOccurance[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            end = Math.max(end, lastOccurance[s.charAt(i) - 'a']);

            if(end == i){
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}