class Solution {
    public boolean detectCapitalUse(String word) {
        // return regexMethod(word);
        return algorithmMethod(word);
    }

    public boolean regexMethod(String word) {
        String pattern = "[A-Z]+|[a-z]+|[A-Z][a-z]+";
        return word.matches(pattern);
    }

    public boolean algorithmMethod(String word) {
        int n = word.length(), upper = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(word.charAt(i))) upper++;
        }
        return upper == n || upper == 0 || (Character.isUpperCase(word.charAt(0)) && upper == 1);
    }
}
