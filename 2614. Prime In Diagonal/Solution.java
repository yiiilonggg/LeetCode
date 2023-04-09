class Solution {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length, res = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i][i])) res = Math.max(res, nums[i][i]);
            if (isPrime(nums[i][n - i - 1])) res = Math.max(res, nums[i][n - i - 1]);
        }
        return res;
    }
    
    public boolean isPrime(int x) {
        if (x == 2) return true;
        if (x < 2 || x % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(x); i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }
}