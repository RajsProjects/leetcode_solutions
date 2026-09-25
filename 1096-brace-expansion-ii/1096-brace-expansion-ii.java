class Solution {

    int index = 0;

    public List<String> braceExpansionII(String expression) {

        Set<String> result = parse(expression);

        List<String> answer = new ArrayList<>(result);

        Collections.sort(answer);

        return answer;
    }

    private Set<String> parse(String s) {

        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();

        // Empty string is the starting point
        current.add("");

        while (index < s.length() && s.charAt(index) != '}') {

            char ch = s.charAt(index);

            // Comma means UNION
            if (ch == ',') {

                result.addAll(current);

                current = new HashSet<>();
                current.add("");

                index++;
            }

            // Opening brace
            else if (ch == '{') {

                index++; // skip '{'

                Set<String> inside = parse(s);

                // Concatenate current × inside
                current = multiply(current, inside);

                index++; // skip '}'
            }

            // Normal character
            else {

                Set<String> letter = new HashSet<>();
                letter.add(String.valueOf(ch));

                current = multiply(current, letter);

                index++;
            }
        }

        // Add last expression
        result.addAll(current);

        return result;
    }

    private Set<String> multiply(Set<String> a, Set<String> b) {

        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}