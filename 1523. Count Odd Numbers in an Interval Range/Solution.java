class Solution {
    public int countOdds(int low, int high) {
        int res = (high - low) / 2;
        if (low % 2 == 1 || high % 2 == 1) return res + 1;
        return res;
    }
}