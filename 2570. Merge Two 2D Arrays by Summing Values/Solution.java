class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] n : nums1) map.put(n[0], n[1]);
        for (int[] n : nums2) map.put(n[0], map.getOrDefault(n[0], 0) + n[1]);
        int n = map.size(), i = 0;
        int[][] res = new int[n][2];
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            res[i][0] = pair.getKey();
            res[i][1] = pair.getValue();
            i++;
        }
        return res;
    }
}