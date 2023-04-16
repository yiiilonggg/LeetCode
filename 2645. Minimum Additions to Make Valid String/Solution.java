class Solution {
    public int addMinimum(String word) {
        int n = word.length(), res = 0, curr = 0;
        char[] ch = word.toCharArray();
        for (char c : ch) {
            while (c - 'a' != curr) {
                res++;
                curr = (curr + 1) % 3;
            }
            curr = (curr + 1) % 3;
        }
        while (curr != 0) {
            res++;
            curr = (curr + 1) % 3;
        }
        return res;
    }
}