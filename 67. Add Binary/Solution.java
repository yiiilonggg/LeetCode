class Solution {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int m = a.length(), n = b.length(), carry = 0, total;
        for (int i = 1; i <= Math.min(m, n); i++) {
            total = a.charAt(m - i) - '0' + b.charAt(n - i) - '0' + carry;
            str.append(total % 2);
            carry = total > 1 ? 1 : 0;
        }
        for (int i = Math.min(m, n) + 1; i <= m; i++) {
            total = a.charAt(m - i) - '0' + carry;
            str.append(total % 2);
            carry = total > 1 ? 1 : 0;
        }
        for (int i = Math.min(m, n) + 1; i <= n; i++) {
            total = b.charAt(n - i) - '0' + carry;
            str.append(total % 2);
            carry = total > 1 ? 1 : 0;
        }
        if (carry > 0) str.append(1);
        return str.reverse().toString();
    }
}