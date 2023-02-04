class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int n = s.length(), diagonal = numRows - 2, step = numRows + diagonal;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i += step) str.append(s.charAt(i));
        for (int i = 1; i < numRows - 1; i++) {
            boolean odd = true;
            for (int j = i; j < n;) {
                str.append(s.charAt(j));
                j = (odd) ? j + (step - i * 2) : j + (i * 2);
                odd = !odd;
            }
        }
        for (int i = numRows - 1; i < n; i += step) str.append(s.charAt(i));
        return str.toString();
    }
}