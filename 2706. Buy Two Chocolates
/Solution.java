class Solution {
    public int buyChoco(int[] prices, int money) {
        int first = 101, second = 101;
        for (int p : prices) {
            if (p < first) {
                second = first;
                first = p;
            } else if (p < second) {
                second = p;
            }
        }
        return (money < first + second) ? money : money - (first + second);
    }
}
