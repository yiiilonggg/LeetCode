class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int[] gradient = grad(coordinates[0], coordinates[1]);
        int n = coordinates.length;
        for (int i = 2; i < n; i++) {
            int[] curr = grad(coordinates[0], coordinates[i]);
            if (curr[0] * gradient[1] != curr[1] * gradient[0]) return false;
        }
        return true;
    }

    public int[] grad(int[] first, int[] second) {
        return new int[] { first[0] - second[0], first[1] - second[1] };
    }
}
