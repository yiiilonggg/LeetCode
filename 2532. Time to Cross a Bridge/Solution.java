class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        PriorityQueue<int[]> leftBank = new PriorityQueue<>((a, b) -> (a[4] == b[4]) ? b[5] - a[5] : b[4] - a[4]);
        PriorityQueue<int[]> rightBank = new PriorityQueue<>((a, b) -> (a[4] == b[4]) ? b[5] - a[5] : b[4] - a[4]);
        PriorityQueue<int[]> leftWarehouse = new PriorityQueue<>((a, b) -> a[6] - b[6]);
        PriorityQueue<int[]> rightWarehouse = new PriorityQueue<>((a, b) -> a[6] - b[6]);
        for (int i = 0; i < k; i++) {
            leftBank.offer(new int[] { time[i][0], time[i][1], time[i][2], time[i][3], time[i][0] + time[i][2], i, 0 });
        }
        int currTime = 0;
        while (n > 0 || !rightBank.isEmpty() || !rightWarehouse.isEmpty()) {
            if (!rightBank.isEmpty()) {
                int[] fromRightBank = rightBank.poll();
                currTime += fromRightBank[2];
                if (n == 0 && rightBank.isEmpty() && rightWarehouse.isEmpty()) return currTime;
                fromRightBank[6] = currTime + fromRightBank[3];
                leftWarehouse.offer(fromRightBank);
            } else if (n > 0 && !leftBank.isEmpty()) {
                int[] fromLeftBank = leftBank.poll();
                n--;
                currTime += fromLeftBank[0];
                fromLeftBank[6] = currTime + fromLeftBank[1];
                rightWarehouse.offer(fromLeftBank);
            } else {
                int[] fromWarehouse;
                if (!rightWarehouse.isEmpty()) {
                    fromWarehouse = rightWarehouse.poll();
                    rightBank.offer(fromWarehouse);
                } else {
                    fromWarehouse = leftWarehouse.poll();
                    leftBank.offer(fromWarehouse);
                }
                currTime = fromWarehouse[6];
            }
            while (!leftWarehouse.isEmpty() && leftWarehouse.peek()[6] <= currTime) {
                leftBank.offer(leftWarehouse.poll());
            }
            while (!rightWarehouse.isEmpty() && rightWarehouse.peek()[6] <= currTime) {
                rightBank.offer(rightWarehouse.poll());
            }
        }
        return -1;
    }
}