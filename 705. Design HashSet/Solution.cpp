class MyHashSet {
public:
    vector<vector<int>> buckets;
    MyHashSet() {
        for (int i = 0; i < 31; i++) {
            vector<int> bucket;
            buckets.push_back(bucket);
        }
    }
    
    void add(int key) {
        int hash = key % 31, first = -1, n = buckets[hash].size();
        bool flag = false;
        for (int i = 0; i < n; i++) {
            if (buckets[hash][i] == key) flag = true;
            if (buckets[hash][i] == -1) first = i;
        }
        if (!flag) {
            if (first == -1) {
                buckets[hash].push_back(key);
            } else {
                buckets[hash][first] = key;
            }
        }
    }
    
    void remove(int key) {
        int hash = key % 31, n = buckets[hash].size();
        for (int i = 0; i < n; i++) {
            if (buckets[hash][i] == key) buckets[hash][i] = -1;
        }
    }
    
    bool contains(int key) {
        int hash = key % 31, n = buckets[hash].size();
        for (int i = 0; i < n; i++) {
            if (buckets[hash][i] == key) return true;
        }
        return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
