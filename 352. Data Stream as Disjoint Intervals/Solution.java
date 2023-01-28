class SummaryRanges {
    TreeMap<Integer, Integer> map;
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int value) {
        Integer ceil = map.ceilingKey(value), floor = map.floorKey(value);
        if (floor != null) {
            if (map.get(floor) >= value) return;
            if (map.get(floor) == value - 1) {
                if (ceil != null && ceil == value + 1) {
                    map.put(floor, map.get(ceil));
                    map.remove(ceil);
                } else {
                    map.put(floor, value);
                }
                return;
            }
        }
        if (ceil != null && ceil == value + 1) {
            map.put(value, map.get(ceil));
            map.remove(ceil);
            return;
        }
        map.put(value, value);
    }
    
    public int[][] getIntervals() {
        int[][] res = new int[map.size()][];
        int i = 0;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            res[i++] = new int[] { pair.getKey(), pair.getValue() };
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */