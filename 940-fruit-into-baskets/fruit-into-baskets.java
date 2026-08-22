class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int right = 0; right < fruits.length; right++){
            int key = fruits[right];
            map.put(key, map.getOrDefault(key, 0) + 1);
            while(map.size() > 2){
                int fruit = fruits[left];

                map.put(fruit, map.get(fruit) - 1);

                if (map.get(fruit) == 0) {
                    map.remove(fruit);
                }

                left++;
            }
             
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}