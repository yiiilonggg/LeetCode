class Solution {
public:
    int comp(int x1, int x2, int y1, int y2) {
        return abs(x1 - y1) + abs(x2 - y2);
    }

    int minimumCost(vector<int>& start, vector<int>& target, vector<vector<int>>& specialRoads) {
        int s = specialRoads.size(), res = comp(start[0], start[1], target[0], target[1]);
        vector<int> dist(s, 2e9);
        auto cmp = [](auto a, auto b) -> bool { return a.first < b.first; };
        priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(cmp)> pq(cmp);
        for (int i = 0; i < s; i++) {
            dist[i] = comp(start[0], start[1], specialRoads[i][0], specialRoads[i][1]) + specialRoads[i][4];
            pq.push({dist[i], i});
        }
        while (!pq.empty()) {
            auto [d_c, c] = pq.top();
            pq.pop();
            if (d_c != dist[c]) continue;
            res = min(res, d_c + comp(specialRoads[c][2], specialRoads[c][3], target[0], target[1]));
            for (int i = 0; i < s; i++) {
                int d = comp(specialRoads[c][2], specialRoads[c][3], specialRoads[i][0], specialRoads[i][1]) + specialRoads[i][4];
                if (d_c + d < dist[i]) {
                    dist[i] = d_c + d;
                    pq.push({dist[i], i});
                }
            }
        }
        return res;
    }
};