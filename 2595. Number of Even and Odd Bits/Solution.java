class Solution {
    public int[] evenOddBit(int n) {
        String s = Integer.toBinaryString(n);
        int even = 0, odd = 0, l = s.length();
        boolean isEven = true;
        for (int i = l - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (isEven) {
                    even++;
                } else {
                    odd++;
                }
            }
            isEven = !isEven;
        }
        return new int[] { even, odd };
    }
}