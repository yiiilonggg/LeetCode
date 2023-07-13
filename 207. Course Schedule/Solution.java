class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer>[] graph = new List[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int visited = 0;
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        for (int[] p : prerequisites) {
            indegree[p[0]]++;
            graph[p[1]].add(p[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            visited++;
            for (int neighbour : graph[curr]) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) q.offer(neighbour);
            }
        }
        return visited == numCourses;
    }
}
