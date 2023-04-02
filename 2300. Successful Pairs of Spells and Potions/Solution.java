class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int left = 0, right = m - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (1L * potions[mid] * spells[i] < success) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            res[i] = (1L * potions[m - 1] * spells[i] < success) ? 0 : m - left;
        }
        return res;
    }
}