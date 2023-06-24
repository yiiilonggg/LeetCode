class Solution {
    public int longestString(int x, int y, int z) {
        return (x != y) ? (2 * Math.min(x, y) + z + 1) * 2 : (2 * Math.min(x, y) + z) * 2; 
    }
}
