class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        int n = answerKey.size(), left = 0, ts = 0, fs = 0, count = 0, high = 0;
        for (int right = 0; right < n; right++) {
            if (answerKey[right] == 'T') {
                ts++;
            } else {
                fs++;
            }
            count = min(ts, fs);
            while (count > k) {
                if (answerKey[left] == 'T') {
                    ts--;
                } else {
                    fs--;
                }
                count = min(ts, fs);
                left++;
            }
            high = max(high, right - left + 1);
        }
        return high;
    }
};
