class Solution {
    public int largestVariance(String s) {
        int high = 0;
        String ch = "abcdefghijklmnopqrstuvwxyz";
        char[] chars = s.toCharArray();
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                char a = ch.charAt(i), b = ch.charAt(j);
                int curr = 0, currHigh = 0, currLow = 0, prevHigh = 0, prevLow = 0;
                boolean hasA = false, hasB = false;
                for (char c : chars) {
                    if (c == a) {
                        hasA = true;
                        curr++;
                        currHigh = Math.max(currHigh, prevHigh);
                        prevHigh = curr;
                    } else if (c == b) {
                        hasB = true;
                        curr--;
                        currLow = Math.min(currLow, prevLow);
                        prevLow = curr;
                    }
                    if (hasA && hasB) high = Math.max(high, Math.max(curr - currLow, currHigh - curr));
                }
            }
        }
        return high;
    }
}
