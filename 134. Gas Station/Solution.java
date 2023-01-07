class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, currStart = 0, currSum = 0, totalGas = 0, totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalCost > totalGas) return -1;
        for (int i = 0; i < n; i++) {
            currSum += gas[i] - cost[i];
            if (currSum < 0) {
                currSum = 0;
                currStart = i + 1;
            }
        }
        return currStart;
    }
}