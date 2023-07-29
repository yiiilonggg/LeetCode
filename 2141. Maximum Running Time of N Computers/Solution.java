class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long left = 1, right = 0;
        for (int b : batteries) right += b;
        right /= n;
        Arrays.sort(batteries);
        while (left < right) {
            long mid = (left + right) / 2;
            if (check(n, batteries, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (check(n, batteries, left)) ? left : left - 1;
    }
    
    public boolean check(int n, int[] arr, long x) {
        long rem = 0;
        for (int i = arr.length - n; i < arr.length; i++) rem += Math.max(1L * x - arr[i], 0L);
        for (int i = 0; i < arr.length - n; i++) rem -= 1L * arr[i];
        return rem <= 0;
    }
}
