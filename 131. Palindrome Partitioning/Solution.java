class Solution {
    List<String> strs;
    int n;
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        strs = new ArrayList<>();
        n = s.length();
        res = new ArrayList<>();
        backtrack(s, 0);
        return res;
    }
    public void backtrack(String s, int start) {
        if (start == n) {
            res.add(new ArrayList<>(strs));
            return;
        }
        for (int i = start; i < n; i++) {
            if (!check(s, start, i)) continue;
            strs.add(s.substring(start, i + 1));
            backtrack(s, i + 1);
            strs.remove(strs.size() - 1);
        }
    }
    public boolean check(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}