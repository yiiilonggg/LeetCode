class Solution {
    public long coloredCells(int n) {
        if (n == 1) return 1;
        return 1 + 2L * (1L * n * 1L * (n - 1));
    }
}