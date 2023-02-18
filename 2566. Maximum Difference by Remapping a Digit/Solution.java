class Solution {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        char c = s.charAt(0), ch = '9';
        int l = s.length(), j = 0;
        while (j < l) {
            if (s.charAt(j) < '9') {
                ch = s.charAt(j);
                break;
            }
            j++;
        }
        StringBuilder high = new StringBuilder(), low = new StringBuilder();
        for (int i = 0; i < l; i++) {
            char curr = s.charAt(i);
            if (curr == c) {
                low.append('0');
            } else {
                low.append(curr);
            }
            if (curr == ch) {
                high.append('9');
            } else {
                high.append(curr);
            }
        }
        return Integer.parseInt(high.toString()) - Integer.parseInt(low.toString());
    }
}