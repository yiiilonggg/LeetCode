class Solution {
    public int alternateDigitSum(int n) {
        int count = 0, res = 0;
        while (n > 0) {
            if (count % 2 == 0) {
                res += n % 10;
            } else {
                res -= n % 10;
            }
            n /= 10;
            count++;
        }
        if (count % 2 == 1) return res;
        return -res;
    }
}