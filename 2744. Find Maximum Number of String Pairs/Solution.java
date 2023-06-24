class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0, n = words.length;
        for (int i = 0; i < n; i++) {
            StringBuilder temp = new StringBuilder(words[i]);
            String rev = temp.reverse().toString();
            for (int j = i + 1; j < n; j++) {
                if (rev.equals(words[j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
