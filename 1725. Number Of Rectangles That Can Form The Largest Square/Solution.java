class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int n = rectangles.length, high = 0, res = 0;
        int[] maxLengths = new int[n];
        for (int i = 0; i < n; i++) {
            maxLengths[i] = Math.min(rectangles[i][0], rectangles[i][1]);
            high = Math.max(high, maxLengths[i]);
        }
        for (int m : maxLengths) {
            if (m == high) res++;
        }
        return res;
    }
}
