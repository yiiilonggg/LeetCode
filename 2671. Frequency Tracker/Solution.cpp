class FrequencyTracker {
public:
    vector<int> freq;
    unordered_map<int, int> nums;

    FrequencyTracker() {
        freq.assign(100001, 0);
    }
    
    void add(int number) {
        if (nums.find(number) != nums.end()) freq[nums[number]]--;
        nums[number] = nums.find(number) != nums.end() ? nums[number] + 1 : 1;
        freq[nums[number]]++;
    }
    
    void deleteOne(int number) {
        if (nums.find(number) == nums.end() || nums[number] == 0) return;
        freq[nums[number]]--;
        freq[nums[number] - 1]++;
        nums[number] = nums[number] - 1;
    }
    
    bool hasFrequency(int frequency) {
        return freq[frequency] > 0;
    }
};

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker* obj = new FrequencyTracker();
 * obj->add(number);
 * obj->deleteOne(number);
 * bool param_3 = obj->hasFrequency(frequency);
 */