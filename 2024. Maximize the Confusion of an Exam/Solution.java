class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length(), left = 0, ts = 0, fs = 0, count = 0, high = 0;
        for (int right = 0; right < n; right++) {
            if (answerKey.charAt(right) == 'T') {
                ts++;
            } else {
                fs++;
            }
            count = Math.min(ts, fs);
            while (count > k) {
                if (answerKey.charAt(left) == 'T') {
                    ts--;
                } else {
                    fs--;
                }
                count = Math.min(ts, fs);
                left++;
            }
            high = Math.max(high, right - left + 1);
        }
        return high;
    }
}
