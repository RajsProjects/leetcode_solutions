    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(s);
            Arrays.sort(g);

            int res = 0;
            
            int j = 0;
            for(int i = 0; i < g.length && j < s.length; i++){
                while(j < s.length){
                    if(s[j] >= g[i]){
                        res = i + 1;
                        j++;
                        break;
                    }
                    j++;
                }
            }
            return res;
        }
    }