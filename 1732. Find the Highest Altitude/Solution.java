class Solution {
    public int largestAltitude(int[] gain) {
        int curr = 0, high = 0;
        for (int g : gain) {
            curr += g;
            high = Math.max(high, curr);
        }
        return high;
    }
}
