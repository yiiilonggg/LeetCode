class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        Set<Character> ch = new HashSet<>();
        char first = ' ', firstC = ' ', second = ' ', secondC = ' ';
        int l = s.length();
        for (int i = 0; i < l; i++) {
            ch.add(s.charAt(i));
            if (s.charAt(i) == goal.charAt(i)) continue;
            if (first == ' ') {
                first = s.charAt(i);
                firstC = goal.charAt(i);
            } else if (second == ' ') {
                second = s.charAt(i);
                secondC = goal.charAt(i);
            } else {
                return false;
            }
        }
        if (first == ' ') return ch.size() < l;
        if (second == ' ') return false;
        return first == secondC && firstC == second;
    }
}
