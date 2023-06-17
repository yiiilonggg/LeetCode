class Solution {
    Map<Pair<Integer, Integer>, Integer> dp = new HashMap<>();

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        int res = dfs(0, -1, arr1, arr2);
        return (res < 2001) ? res : -1;
    }
    public int dfs(int curr, int prev, int[] arr1, int[] arr2) {
        if (curr == arr1.length) return 0;
        if (dp.containsKey(new Pair(curr, prev))) return dp.get(new Pair(curr, prev));
        int cost = 2001;
        if (arr1[curr] > prev) cost = Math.min(cost, dfs(curr + 1, arr1[curr], arr1, arr2));
        int idx = bisect(arr2, prev);
        if (idx < arr2.length) cost = Math.min(cost, 1 + dfs(curr + 1, arr2[idx], arr1, arr2));
        dp.put(new Pair(curr, prev), cost);
        return cost;
    }

    public int bisect(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
