class Solution {
    List<String> res;
    int n, l;
    List<StringBuilder> strs;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        n = s.length();
        l = 0;
        strs = new ArrayList<>();
        strs.add(new StringBuilder());
        strs.add(new StringBuilder());
        strs.add(new StringBuilder());
        strs.add(new StringBuilder());
        backtrack(s, 0, 0);
        return res;
    }
    public void backtrack(String s, int curr, int pointer) {
        if (curr == n) {
            if (pointer < 3) return;
            StringBuilder resBuilder = new StringBuilder();
            for (StringBuilder str : strs) {
                if (str.length() == 0) return;
                if (str.charAt(0) == '0' && str.length() > 1) return;
                resBuilder.append(str.toString());
                resBuilder.append('.');
            }
            resBuilder.deleteCharAt(resBuilder.length() - 1);
            res.add(resBuilder.toString());
            return;
        }
        strs.get(pointer).append(s.charAt(curr));
        if (Integer.parseInt(strs.get(pointer).toString()) <= 255) {
            backtrack(s, curr + 1, pointer);
            if (pointer < 3) backtrack(s, curr + 1, pointer + 1);
        }
        strs.get(pointer).deleteCharAt(strs.get(pointer).length() - 1);
    }
}