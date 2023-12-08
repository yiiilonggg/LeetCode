class Solution {
public:
    int countCharacters(vector<string>& words, string chars) {
        vector<int> counter(26);
        for (char c : chars) {
            counter[c - 'a']++;
        }
        int res = 0;
        for (string word : words) {
            vector<int> wcounter(26);
            bool flag = true;
            for (char c : word) {
                wcounter[c - 'a']++;
            }
            for (int i = 0; i < 26 && flag; i++) {
                if (wcounter[i] > counter[i]) flag = false;
            }
            if (flag) res += word.length();
        }
        return res;
    }
};
