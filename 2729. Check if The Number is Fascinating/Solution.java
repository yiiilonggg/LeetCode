class Solution {
    public boolean isFascinating(int n) {
        String s = Integer.toString(n) + Integer.toString(2 * n) + Integer.toString(3 * n);
        char[] c = s.toCharArray();
        Set<Character> seen = new HashSet<>();
        for (char ch : c) {
            seen.add(ch);
            if (ch == '0') return false;
        }
        return seen.size() == 9 && c.length == 9;
    }
}
