class Solution {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> primes = new HashSet<>();
        for (int n : nums) {
            for (int i = 2; i < Math.ceil(Math.sqrt(n)) + 1; i++) {
                if (n % i == 0) {
                    primes.add(i);
                    while (n % i == 0) n /= i;
                }
            }
            if (n > 1) primes.add(n);
        }
        return primes.size();
    }
}
