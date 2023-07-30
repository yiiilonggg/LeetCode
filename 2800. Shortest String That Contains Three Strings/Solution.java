class Solution {
    Map<String, Map<String, String>> memo = new HashMap<>();
    public String minimumString(String a, String b, String c) {
        String res = a + b + c;
        for (int i = 0; i < 3; i++) {
            String first = overlap(overlap(a, b), c), second = overlap(overlap(a, c), b);
            if (first.length() < res.length() || (first.length() == res.length() && first.compareTo(res) < 0)) res = first;
            if (second.length() < res.length() || (second.length() == res.length() && second.compareTo(res) < 0)) res = second;
            String temp = a;
            a = b;
            b = c;
            c = temp;
        }
        return res;
    }
    public String overlap(String x, String y) {
        if (memo.containsKey(x) && memo.get(x).containsKey(y)) return memo.get(x).get(y);
        if (!memo.containsKey(x)) memo.put(x, new HashMap<>());
        int m = x.length(), n = y.length(), overlap = -1;
        for (int i = 0; i < m - n; i++) {
            if (x.substring(i, i + n).equals(y)) {
                memo.get(x).put(y, x);
                return x;
            }
        }
        for (int i = n; i >= 0; i--) {
            if (i > m) continue;
            if (y.substring(0, i).equals(x.substring(m - i))) {
                overlap = i;
                break;
            }
        }
        memo.get(x).put(y, (overlap == -1) ? x + y : x + y.substring(overlap));
        return memo.get(x).get(y);
    }
}
