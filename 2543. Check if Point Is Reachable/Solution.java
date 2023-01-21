class Solution {
    public boolean isReachable(int targetX, int targetY) {
        while (targetX % 2 == 0) targetX /= 2;
        while (targetY % 2 == 0) targetY /= 2;
        int gcd = gcd(targetX, targetY);
        return gcd == 1;
    }
    public int gcd(int x, int y) {
        if (x < y) return gcd(y, x);
        while (y > 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }
}