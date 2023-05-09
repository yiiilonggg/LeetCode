class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        for (int top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1; top <= bottom && left <= right; top++, bottom--, left++, right--) {
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            if (top == bottom) break;
            for (int i = top + 1; i <= bottom; i++) res.add(matrix[i][right]);
            if (left == right) break;
            for (int i = right - 1; i >= left; i--) res.add(matrix[bottom][i]);
            for (int i = bottom - 1; i >= top + 1; i--) res.add(matrix[i][left]);
        }
        return res;
    }
}