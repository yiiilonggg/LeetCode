class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        for (int i = left; i <= right; i++) {
            String curr = words[i];
            if (vowels.contains(curr.charAt(0)) && vowels.contains(curr.charAt(curr.length() - 1))) count++;
        }
        return count;
    }
}