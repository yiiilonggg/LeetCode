class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length, curr = 0;
        int[] res = new int[n], counter = new int[51];
        for (int i = 0; i < n; i++) {
            if (counter[A[i]] < 0) curr++;
            counter[A[i]]++;
            if (counter[B[i]] > 0) curr++;
            counter[B[i]]--;
            res[i] = curr;
        }
        return res;
    }
}