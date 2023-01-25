class Solution {
    PriorityQueue<Integer> indices;
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        boolean[] visitedOne = new boolean[n];
        boolean[] visitedTwo = new boolean[n];
        Queue<Integer> qOne = new LinkedList<>();
        Queue<Integer> qTwo = new LinkedList<>();
        qOne.offer(node1);
        qTwo.offer(node2);
        indices = new PriorityQueue<>();
        while (!qOne.isEmpty() || !qTwo.isEmpty()) {
            perform(edges, qOne, visitedTwo, visitedOne);
            perform(edges, qTwo, visitedOne, visitedTwo);
            if (!indices.isEmpty()) return indices.poll();
        }
        return -1;
    }
    public void perform(int[] edges, Queue<Integer> q, boolean[] visitedToCheck, boolean[] visitedToEdit) {
        int l = q.size();
        for (int i = 0; i < l; i++) {
            int curr = q.poll();
            if (visitedToCheck[curr]) indices.offer(curr);
            if (visitedToEdit[curr]) continue;
            visitedToEdit[curr] = true;
            if (edges[curr] == -1) continue;
            q.offer(edges[curr]);
        }
    }
}