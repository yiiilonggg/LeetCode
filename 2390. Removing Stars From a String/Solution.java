class Solution {
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] ch = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (char c : ch) {
            if (c == '*') {
                stack.pollLast();
            } else {
                stack.offerLast(c);
            }
        }
        while (!stack.isEmpty()) res.append(stack.pollFirst());
        return res.toString();
    }
}