
class UFDS {
    public:
        vector<int> parent, rank;

        UFDS(int n) {
            parent.assign(n, 0);
            rank.assign(n, 0);
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
            if (same(x, y)) return;
            int a = find(x), b = find(y);
            if (rank[a] > rank[b]) {
                parent[b] = a;
            } else {
                parent[a] = b;
                if (rank[a] == rank[b]) rank[b]++;
            }
            return;
        }
};

class Solution {
public:
    vector<bool> distanceLimitedPathsExist(int n, vector<vector<int>>& edgeList, vector<vector<int>>& queries) {
        int q = queries.size(), e = edgeList.size(), j = 0;
        UFDS uf(n);
        vector<bool> res(q);
        for (int i = 0; i < q; i++) queries[i].push_back(i);
        sort(begin(edgeList), end(edgeList), [&](auto &a, auto &b) -> bool { return a[2] < b[2]; });
        sort(begin(queries), end(queries), [&](auto &a, auto &b) -> bool { return a[2] < b[2]; });
        for (auto query : queries) {
            while (j < e && edgeList[j][2] < query[2]) {
                uf.join(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            res[query[3]] = uf.same(query[0], query[1]);
        }
        return res;
    }
};