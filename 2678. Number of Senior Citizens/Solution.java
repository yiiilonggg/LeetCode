class Solution {
    public int countSeniors(String[] details) {
        int c = 0;
        for (String d : details) {
            int a = Integer.parseInt(d.substring(11, 13));
            if (a > 60) c++;
        }
        return c;
    }
}