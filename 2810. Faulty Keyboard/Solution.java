class Solution {
    public String finalString(String s) {
        StringBuilder str = new StringBuilder();
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (c == 'i') {
                str.reverse();
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }
}
