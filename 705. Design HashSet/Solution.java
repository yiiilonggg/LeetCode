class MyHashSet {
    List<Integer>[] buckets;
    public MyHashSet() {
        buckets = new List[31];
        for (int i = 0; i < 31; i++) buckets[i] = new ArrayList<>();
    }
    
    public void add(int key) {
        int hash = key % 31, first = -1, n = buckets[hash].size();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (buckets[hash].get(i) == key) flag = true;
            if (first == -1 && buckets[hash].get(i) == -1) first = i;
        }
        if (!flag) {
            if (first == -1) {
                buckets[hash].add(key);
            } else {
                buckets[hash].set(first, key);
            }
        }
    }
    
    public void remove(int key) {
        int hash = key % 31, n = buckets[hash].size();
        for (int i = 0; i < n; i++) {
            if (buckets[hash].get(i) == key) buckets[hash].set(i, -1);
        }
    }
    
    public boolean contains(int key) {
        int hash = key % 31, n = buckets[hash].size();
        for (int i = 0; i < n; i++) {
            if (buckets[hash].get(i) == key) return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
