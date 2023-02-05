class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer, Integer> counter = new TreeMap<>();
        int n = basket1.length;
        List<Integer> toSwap = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            counter.put(basket1[i], counter.getOrDefault(basket1[i], 0) + 1);
            counter.put(basket2[i], counter.getOrDefault(basket2[i], 0) - 1);
        }
        for (Map.Entry<Integer, Integer> pair : counter.entrySet()) {
            if (pair.getValue() == 0) continue;
            if (pair.getValue() % 2 == 1) return -1;
            for (int i = 0; i < Math.abs(pair.getValue()) / 2; i++) toSwap.add(pair.getKey());
        }
        long cost = 0;
        int low = counter.firstKey();
        for (int i = 0 ; i < toSwap.size() / 2; i++) {
            cost += Math.min(toSwap.get(i), low * 2);
        }
        return cost;
    }
}