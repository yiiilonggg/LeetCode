class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int currMax = points[0][1], arrows = 1;
        for (int i = 1; i < points.length; i++) {
            if (currMax >= points[i][0]) continue;
            arrows++;
            currMax = points[i][1];
        }
        return arrows;
    }
}