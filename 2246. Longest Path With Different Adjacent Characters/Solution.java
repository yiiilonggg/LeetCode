class Solution {
    public int longestPath(int[] parent, String s) {
        int n = parent.length, res = 1;
        int[] inDegree = new int[n], paths = new int[n];
        Arrays.fill(paths, 1);
        char[] letters = s.toCharArray();
        for (int i = 1; i < n; i++) {
            inDegree[parent[i]]++;
        }
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i < n; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            int currParent = parent[curr];
            if (currParent != 0 && --inDegree[currParent] == 0) q.offer(currParent);
            if (letters[curr] == letters[currParent]) continue;
            res = Math.max(res, paths[curr] + paths[currParent]);
            paths[currParent] = Math.max(paths[currParent], paths[curr] + 1);
        }
        return res;
    }
}