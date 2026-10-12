class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);

        return climb(n, map);
    }

    public int climb(int n, HashMap<Integer, Integer> map){
        if(map.containsKey(n)){
            return map.get(n);
        }

        int result = climb(n - 1, map) + climb(n - 2, map);

        map.put(n, result);
        return result;
    }
}