class Solution {
    public int distinctIntegers(int n) {
        Set<Integer> seen = new HashSet<>();
        seen.add(n);
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j < n; j++) {
                if (i % j == 1) seen.add(j);
            }
        }
        return seen.size();
    }
}