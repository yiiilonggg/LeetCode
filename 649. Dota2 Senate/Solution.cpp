class Solution {
public:
    string predictPartyVictory(string senate) {
        int r = 0, d = 0, rban = 0, dban = 0;
        queue<char> q;
        for (char c : senate) {
            q.push(c);
            if (c == 'R') {
                r++;
            } else {
                d++;
            }
        }
        while (r > 0 && d > 0) {
            char c = q.front();
            q.pop();
            if (c == 'D') {
                if (dban > 0) {
                    dban--;
                    d--;
                } else {
                    rban++;
                    q.push(c);
                }
            } else {
                if (rban > 0) {
                    rban--;
                    r--;
                } else {
                    dban++;
                    q.push(c);
                }
            }
        }
        return (r > 0) ? "Radiant" : "Dire";
    }
};