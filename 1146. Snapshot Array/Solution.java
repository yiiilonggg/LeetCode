class SnapshotArray {
    int s = 0;
    List<int[]>[] arr;

    public SnapshotArray(int length) {
        arr = new List[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new ArrayList<>();
            arr[i].add(new int[] { 0, 0 });
        }    
    }
    
    public void set(int index, int val) {
        if (arr[index].get(arr[index].size() - 1)[0] == s) {
            arr[index].get(arr[index].size() - 1)[1] = val;
        } else {
            arr[index].add(new int[] { s, val });
        }
    }
    
    public int snap() {
        s++;
        return s - 1;
    }
    
    public int get(int index, int snap_id) {
        List<int[]> a = arr[index];
        int left = 0, right = a.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a.get(mid)[0] <= snap_id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return a.get(left - 1)[1];
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
