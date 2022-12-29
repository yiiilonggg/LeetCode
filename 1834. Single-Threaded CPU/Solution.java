class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] res = new int[n];
        int[][] tasksIndexed = new int[n][3];
        for (int i = 0; i < n; i++) {
            tasksIndexed[i][0] = tasks[i][0];
            tasksIndexed[i][1] = tasks[i][1];
            tasksIndexed[i][2] = i;
        }
        Arrays.sort(tasksIndexed, (a, b) -> a[0] - b[0]);
        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[2] - b[2];
            return a[1] - b[1];
        });
        int currTime = tasksIndexed[0][0], taskPointer = 0, resPointer = 0;
        while (!q.isEmpty() || taskPointer < n) {
            if (!q.isEmpty()) {
                int[] currTask = q.poll();
                res[resPointer] = currTask[2];
                resPointer++;
                currTime += currTask[1];
            } else {
                currTime = tasksIndexed[taskPointer][0];
            }
            while (taskPointer < n && tasksIndexed[taskPointer][0] <= currTime) {
                q.offer(tasksIndexed[taskPointer]);
                taskPointer++;
            }
        }
        return res;
    }
}
