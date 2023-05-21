class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        for (int i = 0; i < n / 2; i++) {
            char c = (ch[i] < ch[n - i - 1]) ? ch[i] : ch[n - i - 1];
            ch[i] = c;
            ch[n - i - 1] = c;
        }
        return String.valueOf(ch);
    }
}
