class Solution {

    public int ladderLength(String beginWord,
                            String endWord,
                            List<String> wordList) {

        Map<String, List<String>> patternMap = new HashMap<>();

        // Build wildcard pattern map
        for (String word : wordList) {

            for (int i = 0; i < word.length(); i++) {

                char[] chars = word.toCharArray();
                chars[i] = '*';

                String pattern = new String(chars);

                patternMap
                        .computeIfAbsent(pattern, k -> new ArrayList<>())
                        .add(word);
            }
        }

        return bfs(beginWord, endWord, patternMap);
    }

    public int bfs(String begin,
                   String end,
                   Map<String, List<String>> patternMap) {

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(begin);

        Set<String> visited = new HashSet<>();
        visited.add(begin);

        int steps = 1;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            for (int level = 0; level < levelSize; level++) {

                String current = queue.poll();

                // Generate wildcard patterns
                for (int i = 0; i < current.length(); i++) {

                    char[] chars = current.toCharArray();
                    chars[i] = '*';

                    String pattern = new String(chars);

                    List<String> neighbors = patternMap.get(pattern);

                    if (neighbors != null) {

                        for (String neighbor : neighbors) {

                            if (!visited.contains(neighbor)) {

                                // We have reached the destination
                                if (neighbor.equals(end)) {
                                    return steps + 1;
                                }

                                visited.add(neighbor);
                                queue.offer(neighbor);
                            }
                        }

                        // This pattern has been completely processed
                        neighbors.clear();
                    }
                }
            }

            // Move to the next BFS level
            steps++;
        }

        return 0;
    }
}