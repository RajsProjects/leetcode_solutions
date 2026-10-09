class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;
        int j = 0;

        for (int i = 0; i < g.length && j < s.length; i++) {

            while (j < s.length && s[j] < g[i]) {
                j++;
            }

            if (j < s.length) {
                res++;
                j++;
            }
        }

        return res;
    }
}