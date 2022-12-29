class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<int[]> s = new Stack();
        for (int i = 0; i < n; i++) {
            int curr = temperatures[i];
            while (!s.isEmpty() && s.peek()[0] < curr) {
                int[] polled = s.pop();
                res[polled[1]] = i - polled[1];
            }
            s.push(new int[] { curr, i });
        }
        return res;
    }
}
