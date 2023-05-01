class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int s = specialRoads.length;
        boolean[] visited = new boolean[s];
        for (int i = 0; i < s; i++) {
            if (comp(specialRoads[i][0], specialRoads[i][1], specialRoads[i][2], specialRoads[i][3]) <= specialRoads[i][4]) visited[i] = true;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] { start[0], start[1], 0 });
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] == target[0] && curr[1] == target[1]) return curr[2];
            if (curr.length == 4) {
                if (visited[curr[3]]) continue;
                visited[curr[3]] = true;
            }
            pq.offer(new int[] { target[0], target[1], curr[2] + comp(curr[0], curr[1], target[0], target[1]) });
            for (int i = 0; i < s; i++) {
                if (visited[i]) continue;
                pq.offer(new int[] { specialRoads[i][2], specialRoads[i][3], curr[2] + comp(curr[0], curr[1], specialRoads[i][0], specialRoads[i][1]) + specialRoads[i][4], i });
            }
        }
        return comp(start[0], start[1], target[0], target[1]);
    }
    public int comp(int x1, int x2, int y1, int y2) {
        return Math.abs(x1 - y1) + Math.abs(x2 - y2);
    }
}