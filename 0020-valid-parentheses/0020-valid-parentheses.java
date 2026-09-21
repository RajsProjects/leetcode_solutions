class Solution {
    public boolean isValid(String s) {

        Map<Character, Character> pairs = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
        );

        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if(pairs.containsKey(c)){
                stack.push(pairs.get(c));
            } else {
                if(stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}