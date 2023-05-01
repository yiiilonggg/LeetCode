class Solution {
    public double average(int[] salary) {
        double total = 0, high = 0, low = 1e6;
        for (int s : salary) {
            total += s;
            high = Math.max(high, s);
            low = Math.min(low, s);
        }
        return (total - high - low) / (salary.length - 2);
    }
}