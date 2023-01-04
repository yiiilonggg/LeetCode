class Solution {
    public int minimumRounds(int[] tasks) {
        if (tasks.length == 1) return -1;
        Arrays.sort(tasks);
        int res = 0, count = 0, prev = 0;
        for (int task : tasks) {
            if (task == prev) {
                count++;
            } else {
                if (count == 1) return -1;
                res += (count + 2) / 3;
                count = 1;
                prev = task;
            }
        }
        if (count == 1) return -1;
        return res + (count + 2) / 3;
    }
}
