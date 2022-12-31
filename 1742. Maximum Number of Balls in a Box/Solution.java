class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        // int[] counts = bruteforce(lowLimit, highLimit);
        int[] counts = pattern(lowLimit, highLimit);
        int res = 0;
        for (int c : counts) res = Math.max(res, c);
        return res;
    }

    public int[] bruteforce(int lowLimit, int highLimit) {
        int[] counts = new int[46];
        for (int i = lowLimit; i < highLimit + 1; i++) {
            int curr = i, currSum = 0;
            while (curr > 0) {
                currSum += curr % 10;
                curr /= 10;
            }
            counts[currSum]++;
        }
        return counts;
    }

    public int[] pattern(int lowLimit, int highLimit) {
        int[] counts = new int[46];
        int low = lowLimit, pointer = 0;
        while (low > 0) {
            pointer += low % 10;
            low /= 10;
        }
        counts[pointer]++;
        for (int i = lowLimit + 1; i < highLimit + 1; i++) {
            int curr = i;
            while (curr % 10 == 0) {
                pointer -= 9;
                curr /= 10;
            }
            pointer++;
            counts[pointer]++;
        }
        return counts;
    }
}
