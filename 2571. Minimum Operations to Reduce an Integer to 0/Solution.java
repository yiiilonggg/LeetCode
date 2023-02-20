class Solution {
    public int minOperations(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (n == 1 || (n & 2) == 0) {
                    n -= 1;
                } else {
                    n += 1;
                }
                count++;
            } else {
                n >>= 1;
            }
        }
        return count;
    }
}