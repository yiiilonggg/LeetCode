class Solution {
    public int minFlipsMonoIncr(String s) {
        // return dp(s);
        return logic(s);
    }

    public int logic(String s) {
        int zeros = 0, oneToZeros = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                oneToZeros++;
            }
            zeros = Math.min(zeros, oneToZeros);
        }
        return zeros;
    }

    public int dp(String s) {
        int n = s.length(), res = 100001;
        int[] oneToZero = new int[n + 1], zeroToOne = new int[n + 1];
        for (int i = 0; i < n; i++) {
            oneToZero[i + 1] = (s.charAt(i) == '1') ? oneToZero[i] + 1 : oneToZero[i];
            zeroToOne[n - i - 1] = (s.charAt(n - i - 1) == '0') ? zeroToOne[n - i] + 1 : zeroToOne[n - i];
        }
        for (int i = 0; i < n; i++) {
            res = Math.min(res, oneToZero[i + 1] + zeroToOne[i]);
        }
        return res - 1;
    }
}