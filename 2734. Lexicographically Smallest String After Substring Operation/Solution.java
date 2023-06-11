class Solution {
    public String smallestString(String s) {
        boolean change = false;
        int l = s.length(), i =  0;
        char[] ch = s.toCharArray();
        while (i < l && ch[i] == 'a') i += 1;
        if (i == l) return s.substring(0, l - 1) + "z";
        while (i < l && ch[i] != 'a') {
            ch[i] = (char) (ch[i] - 1);
            i += 1;
        }
        StringBuilder str = new StringBuilder();
        for (char c : ch) str.append(c);
        return str.toString();
    }
}
