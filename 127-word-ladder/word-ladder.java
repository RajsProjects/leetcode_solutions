    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            
            if(!wordSet.contains(endWord)){
                return 0;
            }

            Queue<String> queue = new ArrayDeque<>();
            queue.offer(beginWord);

            wordSet.remove(beginWord);
            
            int steps = 1;

            return bfs(beginWord,
                    endWord,
                    wordSet, 
                    queue, 
                    steps);
        }

        public int bfs(String word,
                    String endWord,
                    Set<String> wordSet,
                    Queue<String> queue,
                    int steps)
        {
            while(!queue.isEmpty()){
                
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {

                    String current = queue.poll();

                    for(int k = 0; k < current.length(); k++){

                        char[] chars = current.toCharArray();
                        
                        for(int j = 0; j < 26; j++){
                            char c = (char) ('a' + j);
                            chars[k] = c;

                            String candidate = new String(chars);

                            if(wordSet.contains(candidate)){
                                if(candidate.equals(endWord)){
                                    return steps + 1;
                                }
                                wordSet.remove(candidate);
                                queue.offer(candidate);
                            } 
                        }
                    }
                }
                steps++;
            }

            return 0;
        }
    }