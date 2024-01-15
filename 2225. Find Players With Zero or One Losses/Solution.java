class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] wins = new int[100001];
        int[] loses = new int[100001];
        for (int[] match : matches) {
            wins[match[0]]++;
            loses[match[1]]++;
        }
        List<Integer> zeros = new ArrayList<>();
        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < 100001; i++) {
            if (wins[i] != 0 && loses[i] == 0) {
                zeros.add(i);
            } else if (loses[i] == 1) {
                ones.add(i);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(zeros);
        res.add(ones);
        return res;
    }
}
