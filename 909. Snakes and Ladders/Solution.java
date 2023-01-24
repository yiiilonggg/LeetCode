class Solution {
    int n;
    public int snakesAndLadders(int[][] board) {
        n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        for (int move = 0; !q.isEmpty(); move++) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int curr = q.poll();
                if (visited[curr]) continue;
                visited[curr] = true;
                if (curr == n * n) return move;
                for (int nxt = Math.min(n * n, curr + 6); nxt > curr; nxt--) {
                    int c = nxt;
                    int val = getVal(board, c);
                    if (val > 0) c = val;
                    if (!visited[c]) q.offer(c);
                }
            }
        }
        return -1;
    }
    public int getVal(int[][] board, int num) {
        int r = (num - 1) / n;
        int x = n - 1 - r;
        int y = r % 2 == 0 ? num - 1 - r * n : n + r * n - num;
        return board[x][y];
    }
}