class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> a = new HashSet<>(), b = new HashSet<>(), c = new HashSet<>(), d = new HashSet<>();
        for (int n : nums1) a.add(n);
        for (int n : nums2) b.add(n);
        for (int n : nums1) if (!b.contains(n)) c.add(n);
        for (int n : nums2) if (!a.contains(n)) d.add(n);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(c));
        res.add(new ArrayList<>(d));
        return res;
    }
}