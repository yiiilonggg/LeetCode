class Solution {
    public int compress(char[] chars) {
        int n = chars.length, pointer = 0, editPointer = 0;
        while (pointer < n) {
            int start = pointer;
            while (pointer < n - 1 && chars[pointer] == chars[pointer + 1]) pointer++;
            chars[editPointer] = chars[start];
            if (pointer - start > 0) {
                editPointer++;
                int total = pointer - start + 1, divisor = 1000;
                boolean flag = false;
                while (total > 0) {
                    if (total / divisor > 0) {
                        chars[editPointer] = (char) (total / divisor + '0');
                        editPointer++;
                        if (divisor > 1 && total % divisor == 0) flag = true;
                        total -= (total / divisor) * divisor;
                    }
                    divisor /= 10;
                }
                if (flag) {
                    while (divisor > 0) {
                        chars[editPointer] = '0';
                        editPointer++;
                        divisor /= 10;
                    }
                }
                editPointer--;
            }
            pointer++;
            editPointer++;
        }
        return editPointer;
    }
}