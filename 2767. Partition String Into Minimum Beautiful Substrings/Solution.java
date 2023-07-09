class Solution {
    int low = 16;
    public int minimumBeautifulSubstrings(String s) {
        r(s, 0, new StringBuilder(), 0);
        return (low < 16) ? low : -1;
    }

    public void r(String s, int curr, StringBuilder x, int count) {
        if (curr == s.length()) {
            if (x.isEmpty()) {
                low = Math.min(low, count);
            } else {
                if (check(Integer.parseInt(x.toString(), 2))) low = Math.min(low, count + 1);
            }
            return;
        }
        if (x.isEmpty() && s.charAt(curr) == '0') return;
        x.append(s.charAt(curr));
        if (check(Integer.parseInt(x.toString(), 2))) r(s, curr + 1, new StringBuilder(), count + 1);
        r(s, curr + 1, x, count);
    }

    public boolean check(int x) {
        if (x == 0) return false;
        while (x > 1) {
            if (x % 5 != 0) return false;
            x /= 5;
        }
        return true;
    }
}
