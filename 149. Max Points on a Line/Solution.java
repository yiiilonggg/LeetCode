class Solution {
    public int maxPoints(int[][] points) {
        int high = 1, INF = Integer.MAX_VALUE, n = points.length;
        for (int i = 0; i < n; i++) {
            float x1 = (float) points[i][0], y1 = (float) points[i][1];
            Map<Float, Integer> counter = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                float x2 = (float) points[j][0], y2 = (float) points[j][1];
                float dx = x1 - x2, dy = y1 - y2;
                float dydx = (dx == 0) ? INF : dy / dx;
                counter.put(dydx, counter.getOrDefault(dydx, 0) + 1);
            }
            for (Map.Entry<Float, Integer> pair : counter.entrySet()) high = Math.max(high, pair.getValue() + 1);
        }
        return high;
    }
}