class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long low = 1;
        long high = (long) minCoin(coins) * k;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins) {
        long total = 0;
        int n = coins.length;

        // Inclusion-exclusion over all subsets
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    lcm = lcm(lcm, coins[i]);

                    // This subset contributes nothing if LCM > x
                    if (lcm > x) {
                        break;
                    }
                }
            }

            if (lcm > x) {
                continue;
            }

            long ways = x / lcm;

            if ((bits & 1) == 1) {
                total += ways;
            } else {
                total -= ways;
            }
        }

        return total;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private int minCoin(int[] coins) {
        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            min = Math.min(min, coin);
        }

        return min;
    }
}