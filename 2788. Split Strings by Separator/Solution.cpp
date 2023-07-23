class Solution {
public:
    vector<string> splitWordsBySeparator(vector<string>& words, char separator) {
        vector<string> res;
        for (const auto word : words) {
            int left = 0, l = word.size();
            for (int right = 0; right < l; right++) {
                if (word[right] == separator) {
                    if (right > left) res.push_back(word.substr(left, right - left));
                    left = right + 1;
                }
            }
            if (left < l) res.push_back(word.substr(left, l - left));
        }
        return res;
    }
};
