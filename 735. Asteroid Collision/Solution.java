class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>(), res = new ArrayDeque<>();
        for (int a : asteroids) {
            if (a < 0) {
                while (!stack.isEmpty() && stack.peekLast() < -a) {
                    stack.pollLast();
                } 
                if (!stack.isEmpty() && stack.peekLast() == -a) {
                    stack.pollLast();
                } else if (stack.isEmpty()) {
                    res.offerLast(a);
                }
            } else {
                stack.offerLast(a);
            }
        }
        int l = stack.size() + res.size(), i = 0;
        int[] ans = new int[l];
        while (!res.isEmpty()) {
            ans[i] = res.pollFirst();
            i++;
        }
        while (!stack.isEmpty()) {
            ans[i] = stack.pollFirst();
            i++;
        }
        return ans;
    }
}
