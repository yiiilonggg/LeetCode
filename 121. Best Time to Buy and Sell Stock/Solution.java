class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, high = prices[n - 1], res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res = Math.max(res, high - prices[i]);
            high = Math.max(high, prices[i]);
        }
        return res;
    }
}