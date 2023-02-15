class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int n = num.length, carry = 0, total, i;
        for (i = 1; i <= n; i++) {
            total = num[n - i] + k % 10 + carry;
            res.add(total % 10);
            carry = total / 10;
            k /= 10;
        }
        k += carry;
        while (k > 0) {
            res.add(k % 10);
            k /= 10;
        }
        Collections.reverse(res);
        return res;
    }
}