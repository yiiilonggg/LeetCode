class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            int left = 0, l = word.length();
            for (int right = 0; right < l; right++) {
                if (word.charAt(right) == separator) {
                    if (right > left) res.add(word.substring(left, right));
                    left = right + 1;
                }
            }
            if (left < l) res.add(word.substring(left));
        }
        return res;
    }
}
