class Solution {
    public int minimumPartition(String s, int k) {
        int n = s.length(), res = 0;
        if (k < 10) {
            char high = '1';
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) > high) high = s.charAt(i);
            }
            return (high - '1' > k) ? -1 : n;
        }
        StringBuilder curr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (Long.parseLong(curr.toString().concat(Character.toString(s.charAt(i)))) > (long) k) {
                if (curr.length() == 0) return -1;
                res++;
                curr = new StringBuilder();
            }
            curr.append(s.charAt(i));
        }
        return res + 1;
    }
}
