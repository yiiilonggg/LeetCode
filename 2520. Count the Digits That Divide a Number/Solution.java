class Solution {
    public int countDigits(int num) {
        int copy = num, count = 0;
        while (copy > 0) {
            int curr = copy % 10;
            if (num % curr == 0) count++;
            copy /= 10;
        }
        return count;
    }
}
