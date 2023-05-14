class UFDS {
public:
    vector<int> parent, rank, size, edges;
    
    UFDS(int n) {
        parent.assign(n, 0);
        rank.assign(n, 0);
        size.assign(n, 1);
        edges.assign(n, 0);
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    
    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    
    bool same(int x, int y) {
        return find(x) == find(y);
    }
    
    void join(int x, int y) {
        if (same(x, y)) {
            edges[find(x)]++;
            return;
        }
        int a = find(x), b = find(y);
        if (rank[a] > rank[b]) {
            parent[b] = a;
            size[a] += size[b];
            edges[a] += edges[b] + 1;
        } else {
            parent[a] = b;
            size[b] += size[a];
            edges[b] += edges[a] + 1;
            if (rank[a] == rank[b]) rank[b]++;
        }
    }
    
    bool isCCC(int x) {
        return edges[x] == size[x] * (size[x] - 1) / 2;
    }
};

class Solution {
public:
    int countCompleteComponents(int n, vector<vector<int>>& edges) {
        UFDS uf(n);
        unordered_set<int> p;
        for (vector<int> e : edges) uf.join(e[0], e[1]);
        for (int i = 0; i < n; i++) {
            int q = uf.find(i);
            if (p.find(q) != p.end()) continue;
            if (uf.isCCC(q)) p.insert(q);
        }
        return p.size();
    }
};