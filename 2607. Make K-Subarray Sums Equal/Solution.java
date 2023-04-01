class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        long total = 0;
        int n = arr.length;
        boolean[] seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (seen[i]) continue;
            List<Integer> a = new ArrayList<>();
            a.add(arr[i]);
            int j = (i + k) % n;
            while (j != i) {
                a.add(arr[j]);
                seen[j] = true;
                j = (j + k) % n;
            }
            Collections.sort(a);
            int median = a.get(a.size() / 2);
            for (int b = 0; b < a.size(); b++) {
                total += Math.abs(a.get(b) - median);
            }
        }
        return total;
    }
}