class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, diff = arr[1] - arr[0];
        for (int i = 2; i < n; i++) {
            if (diff != arr[i] - arr[i - 1]) return false;
        }
        return true;
    }
}
