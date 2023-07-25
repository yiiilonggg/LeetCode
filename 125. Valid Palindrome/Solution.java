class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        char[] ch = s.toCharArray();
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(ch[left])) left++;
            while (left < right && !Character.isLetterOrDigit(ch[right])) right--;
            if (Character.isUpperCase(ch[left])) {
                ch[left] = (char) (ch[left] + 32);
            } else if (Character.isUpperCase(ch[right])) {
                ch[right] = (char) (ch[right] + 32);
            } else if (ch[left] == ch[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
