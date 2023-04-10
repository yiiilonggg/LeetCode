class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> b = new HashMap<>();
        b.put('(', ')');
        b.put('[', ']');
        b.put('{', '}');
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (b.containsKey(c)) {
                stack.offerLast(c);
            } else {
                if (stack.isEmpty()) return false;
                if (b.get(stack.peekLast()) != c) return false;
                stack.pollLast();
            }
        }
        return stack.isEmpty();
    }
}