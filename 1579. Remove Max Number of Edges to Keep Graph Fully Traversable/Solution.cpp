class UFDS {
    public:
        vector<int> parent, rank;
        int sets;

        UFDS(int n) {
            parent.assign(n + 1, 0);
            rank.assign(n + 1, 0);
            sets = n;
            for (int i = 0; i < n + 1; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        bool same(int x, int y) {
            return find(x) == find(y);
        }

        void join(int x, int y) {
            if (same(x, y)) return;
            int a = find(x), b = find(y);
            if (rank[a] > rank[b]) {
                parent[b] = a;
            } else {
                parent[a] = b;
                if (rank[a] == rank[b]) rank[b]++;
            }
            sets--;
        }
};

class Solution {
public:
    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
        UFDS a(n), b(n);
        int res = 0;
        for (auto& e : edges) {
            if (e[0] != 3) continue;
            if (a.same(e[1], e[2])) res++;
            a.join(e[1], e[2]);
            b.join(e[1], e[2]);
        }
        if (a.sets == 1) return edges.size() - n + 1;
        for (auto& e : edges) {
            if (e[0] == 1) {
                if (a.same(e[1], e[2])) res++;
                a.join(e[1], e[2]);
            } else if (e[0] == 2) {
                if (b.same(e[1], e[2])) res++;
                b.join(e[1], e[2]);
            }
        }
        return (a.sets > 1 || b.sets > 1) ? -1 : res;
    }
};