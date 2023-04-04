class Solution {
    public int partitionString(String s) {
        boolean[] tracker = new boolean[26];
        int count = 0, l = s.length();
        for (int i = 0; i < l; i++) {
            if (tracker[s.charAt(i) - 'a']) {
                count++;
                tracker = new boolean[26];
            }
            tracker[s.charAt(i) - 'a'] = true;
        }
        return count + 1;
    }
}