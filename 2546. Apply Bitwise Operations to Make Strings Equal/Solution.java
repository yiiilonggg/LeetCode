class Solution {
    /**
        i = 0, j = 0 -> i = 0, j = 0
        i = 0, j = 1 -> i = 1, j = 1
        i = 1, j = 0 -> i = 1, j = 1
        i = 1, j = 1 -> i = 1, j = 0
    */
    public boolean makeStringsEqual(String s, String target) {
        int sOnes = 0, targetOnes = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') sOnes++;
            if (target.charAt(i) == '1') targetOnes++;
        }
        if (targetOnes == 0 && sOnes > 0) return false;
        if (targetOnes > 0 && sOnes == 0) return false;
        return true;
    }
}