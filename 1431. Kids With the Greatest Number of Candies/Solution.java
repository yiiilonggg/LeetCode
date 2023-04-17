class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int high = 0;
        for (int c : candies) high = Math.max(high, c);
        List<Boolean> res = new ArrayList<>();
        for (int c : candies) res.add(c + extraCandies >= high);
        return res;
    }
}