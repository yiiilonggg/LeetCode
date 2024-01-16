class RandomizedSet {
    private Map<Integer, Integer> m;
    private List<Integer> l;
    private Random rand;

    public RandomizedSet() {
        m = new HashMap();
        l = new ArrayList();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (!m.containsKey(val)) {
            m.put(val, l.size());
            l.add(val);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean remove(int val) {
        if (m.containsKey(val)) {
            int idx = m.get(val);
            if (idx < l.size() - 1) {
                int last = l.get(l.size() - 1);
                m.put(last, idx);
                l.set(idx, last);
                l.set(l.size() - 1, val);
            }
            l.remove(l.size() - 1);
            m.remove(val);
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        return l.get( rand.nextInt(l.size()) );
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
