class LFUCache {
    Map<Integer, Integer> tracker;
    Map<Integer, Queue<Integer>> freqQueues;
    int[] counter;
    int maxSize, currSize, lowFreq;

    public LFUCache(int capacity) {
        tracker = new HashMap<>();
        freqQueues = new HashMap<>();
        freqQueues.put(1, new LinkedList<>());
        counter = new int[100001];
        maxSize = capacity;
        currSize = 0;
        lowFreq = 1;
    }
    
    public int get(int key) {
        if (!tracker.containsKey(key)) return -1;
        counter[key]++;
        if (!freqQueues.containsKey(counter[key])) freqQueues.put(counter[key], new LinkedList<>());
        freqQueues.get(counter[key]).offer(key);
        return tracker.get(key);
    }
    
    public void put(int key, int value) {
        if (!tracker.containsKey(key)) {
            if (maxSize == 0) return;
            if (currSize == maxSize) {
                boolean found = false;
                while (!found) {
                    Queue<Integer> curr = freqQueues.get(lowFreq);
                    while (!found && !curr.isEmpty()) {
                        int candidate = curr.poll();
                        if (counter[candidate] != lowFreq) continue;
                        tracker.remove(candidate);
                        counter[candidate] = 0;
                        found = true;
                    }
                    if (!found) lowFreq++;
                }
            } else {
                currSize++;
            }
            lowFreq = 1;
        }
        counter[key]++;
        if (!freqQueues.containsKey(counter[key])) freqQueues.put(counter[key], new LinkedList<>());
        freqQueues.get(counter[key]).offer(key);
        tracker.put(key, value);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */