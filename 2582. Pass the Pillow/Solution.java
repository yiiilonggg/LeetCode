class Solution {
    public int passThePillow(int n, int time) {
        int c = time / (n - 1), r = time % (n - 1);
        return (c % 2 == 0) ? 1 + r : n - r;
    }
}