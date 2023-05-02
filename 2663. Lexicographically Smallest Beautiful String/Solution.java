class Solution {
    public String smallestBeautifulString(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length, i = n - 1;
        while (i >= 0) {
            ch[i]++;
            if (ch[i] == (char) ('a' + k)) {
                i--;
            } else if ((i - 1 < 0 || ch[i - 1] != ch[i]) && (i - 2 < 0 || ch[i - 2] != ch[i])) {
                for (int j = i + 1; j < n; j++) {
                    boolean[] can = new boolean[3];
                    for (int l = Math.max(0, j - 2); l < j; l++) {
                        if (ch[l] - 'a' > 2) continue;
                        can[ch[l] - 'a'] = true;
                    }
                    for (int l = 0; l < 3; l++) {
                        if (!can[l]) {
                            ch[j] = (char) ('a' + l);
                            break;
                        }
                    }
                }
                StringBuilder str = new StringBuilder();
                for (char c : ch) str.append(c);
                return str.toString();
            }
        }
        return "";
    }
}