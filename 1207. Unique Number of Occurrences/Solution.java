class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> seen = new HashMap<>();
        Set<Integer> seenValues = new HashSet<>();
        for (int a : arr) {
            seen.put(a, seen.getOrDefault(a, 0) + 1);
        }
        for (Integer value : seen.values()) {
            if (seenValues.contains(value)) return false;
            seenValues.add(value);
        }
        return true;
    }
}
