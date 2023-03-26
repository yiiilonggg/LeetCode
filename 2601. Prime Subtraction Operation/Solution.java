class Solution {
    TreeSet<Integer> primes;
    public boolean primeSubOperation(int[] nums) {
        primes = findPrimes();
        return backtrack(nums, nums.length - 2);
    }
    
    public boolean backtrack(int[] nums, int curr) {
        if (curr == -1) return true;
        if (nums[curr] < nums[curr + 1]) return backtrack(nums, curr - 1);
        int x = nums[curr] - nums[curr + 1];
        Integer c = (primes.contains(x)) ? primes.ceiling(x + 1) : primes.ceiling(x);
        if (c == null || nums[curr] - c <= 0) return false;
        nums[curr] -= c;
        return backtrack(nums, curr - 1);
    }
    
    public TreeSet<Integer> findPrimes() {
        boolean[] sieve = new boolean[1000];
        Arrays.fill(sieve, true);
        TreeSet<Integer> primes = new TreeSet<Integer>();
        for (int i = 2; i < 1000; i++) {
            if (!sieve[i]) continue;
            for (int j = i + i; j < 1000; j += i) sieve[j] = false;
            primes.add(i);
        }
        return primes;
    }
}