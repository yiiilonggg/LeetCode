class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length, prefix = 0, total = 0;
        for (int i = n - 1; i >= 0; i--) {
            prefix += satisfaction[i];
            if (prefix < 0) break;
            total += prefix;
        }
        return total;
    }
}