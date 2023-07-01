class Solution {
    int low;

    public int distributeCookies(int[] cookies, int k) {
        low = 0;
        for (int c : cookies) low += c;
        r(cookies, k, 0, new int[k], k, 0);
        return low;
    }

    public void r(int[] cookies, int k, int curr, int[] kids, int zero, int high) {
        if (cookies.length - curr < zero) return;
        if (curr == cookies.length) {
            low = Math.min(low, high);
            return;
        }
        if (high > low) return;
        for (int i = 0; i < k; i++) {
            zero -= (kids[i] == 0) ? 1 : 0;
            kids[i] += cookies[curr];
            int currHigh = Math.max(high, kids[i]);
            r(cookies, k, curr + 1, kids, zero, currHigh);
            kids[i] -= cookies[curr];
            zero += (kids[i] == 0) ? 1 : 0;
        }
    }
}
