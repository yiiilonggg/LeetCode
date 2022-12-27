class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        long total = 0;
        int n = capacity.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = capacity[i] - rocks[i];
            total += diff[i];
        }
        if (total <= additionalRocks) return n;
        Arrays.sort(diff);
        for (int i = 0; i < n; i++) {
            if (diff[i] > additionalRocks) return i;
            additionalRocks -= diff[i];
        }
        return n;
    }
}
