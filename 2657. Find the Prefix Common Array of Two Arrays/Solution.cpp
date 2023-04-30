class Solution {
public:
    vector<int> findThePrefixCommonArray(vector<int>& A, vector<int>& B) {
        int n = A.size(), curr = 0;
        vector<int> res(n), counter(51);
        for (int i = 0; i < n; i++) {
            if (counter[A[i]] < 0) curr++;
            counter[A[i]]++;
            if (counter[B[i]] > 0) curr++;
            counter[B[i]]--;
            res[i] = curr;
        }
        return res;
    }
};