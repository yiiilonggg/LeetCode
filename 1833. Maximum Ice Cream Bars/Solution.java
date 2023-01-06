class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // return prefixSumSolution(costs, coins);
        return pointersSolution(costs, coins);
    }

    private int prefixSumSolution(int[] costs, int coins) {
        Arrays.sort(costs);
        int n = costs.length, count = 0;
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            prefix[i] = (i == 0) ? costs[i] : prefix[i - 1] + costs[i];
            if (prefix[i] > coins) return i;
        }
        return n;
    }

    private int pointersSolution(int[] costs, int coins) {
        int[] freq = new int[100001];
        for (int c : costs) freq[c]++;
        int count = 0;
        for (int i = 0; i < 100001; i++) {
            if (freq[i] == 0) continue;
            int currMax = Math.min(coins / i, freq[i]);
            count += currMax;
            coins -= i * currMax;
            if (coins <= 0 && freq[i] - currMax >= 0) break;
        }
        return count;

    }
}