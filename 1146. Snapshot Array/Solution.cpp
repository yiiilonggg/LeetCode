class SnapshotArray {
public:
    int s = 0;
    vector<vector<pair<int, int>>> arr;

    SnapshotArray(int length) {
        arr.resize(length);
        for (int i = 0; i < length; i++) {
            pair<int, int> p(0, 0);
            arr[i].push_back(p);
        }
    }
    
    void set(int index, int val) {
        if (arr[index][arr[index].size() - 1].first == s) {
            arr[index][arr[index].size() - 1].second = val;
        } else {
            pair<int, int> p(s, val);
            arr[index].push_back(p);
        }
    }
    
    int snap() {
        s++;
        return s - 1;
    }
    
    int get(int index, int snap_id) {
        auto it = upper_bound(begin(arr[index]), end(arr[index]), make_pair(snap_id, INT_MAX));
        return prev(it)->second;
    }
};

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray* obj = new SnapshotArray(length);
 * obj->set(index,val);
 * int param_2 = obj->snap();
 * int param_3 = obj->get(index,snap_id);
 */
