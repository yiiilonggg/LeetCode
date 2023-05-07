class FrequencyTracker {

    int[] freq;
    Map<Integer, Integer> nums;
    
    public FrequencyTracker() {
        freq = new int[100001];
        nums = new HashMap<>();
    }
    
    public void add(int number) {
        if (nums.containsKey(number)) freq[nums.get(number)]--;
        nums.put(number, nums.getOrDefault(number, 0) + 1);
        freq[nums.get(number)]++;
    }
    
    public void deleteOne(int number) {
        if (!nums.containsKey(number) || nums.get(number) == 0) return;
        freq[nums.get(number)]--;
        freq[nums.get(number) - 1]++;
        nums.put(number, nums.get(number) - 1);
    }
    
    public boolean hasFrequency(int frequency) {
        return freq[frequency] > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */