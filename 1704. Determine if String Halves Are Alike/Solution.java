class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length(), tracker = 0;
        Set<Character> vowels = new HashSet<>(List.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        for (int i = 0; i < n / 2; i++) {
            if (vowels.contains(s.charAt(i))) tracker++;
        }
        for (int i = n / 2; i < n; i++) {
            if (vowels.contains(s.charAt(i))) tracker--;
        }
        return tracker == 0;
    }
}
