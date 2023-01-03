class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length, l = strs[0].length(), count = 0;
        for (int i = 0; i < l; i++) {
            char prev = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) < prev) {
                    count++;
                    break;
                }
                prev = strs[j].charAt(i);
            }
        }
        return count;
    }
}
