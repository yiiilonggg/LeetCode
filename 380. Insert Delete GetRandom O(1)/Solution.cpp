class RandomizedSet {
public:
    unordered_map<int,int>m;
    vector<int>a;
    RandomizedSet() {
    }
    
    bool insert(int val) {
        if(m.find(val)!=m.end())return 0;
        m[val]=a.size();
        a.push_back(val);
        return 1;
    }
    
    bool remove(int val) {
        if(m.find(val)==m.end())return 0;
        a[m[val]]=a[a.size()-1];
        m[a[a.size()-1]]=m[val];
        a.pop_back();
        m.erase(val);
        return 1;
    }
    
    int getRandom() {
        return (a.size()>0)?a[rand()%a.size()]:0;
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */
