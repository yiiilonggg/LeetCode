class Solution {
    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (c == 'B') {
                if (!stack.isEmpty() && stack.peekLast() == 'A') {
                    stack.pollLast();
                } else {
                    stack.offerLast(c);
                }
            } else if (c == 'D') {
                if (!stack.isEmpty() && stack.peekLast() == 'C') {
                    stack.pollLast();
                } else {
                    stack.offerLast(c);
                }
            } else {
                stack.offerLast(c);
            }
        }
        return stack.size();
    }
}
