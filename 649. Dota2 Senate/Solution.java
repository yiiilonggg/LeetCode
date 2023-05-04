class Solution {
    public String predictPartyVictory(String senate) {
        int r = 0, d = 0, rban = 0, dban = 0;
        Queue<Character> q = new LinkedList<>();
        for (char c : senate.toCharArray()) {
            q.offer(c);
            if (c == 'R') {
                r++;
            } else {
                d++;
            }
        }
        while (r > 0 && d > 0) {
            char curr = q.poll();
            if (curr == 'D') {
                if (dban > 0) {
                    dban--;
                    d--;
                } else {
                    rban++;
                    q.offer(curr);
                }
            } else {
                if (rban > 0) {
                    rban--;
                    r--;
                } else {
                    dban++;
                    q.offer(curr);
                }
            }
        }
        return r > 0 ? "Radiant" : "Dire";
    }
}