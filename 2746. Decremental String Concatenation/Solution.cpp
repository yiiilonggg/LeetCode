class Solution {
public:
    unordered_map<int, unordered_map<char, unordered_map<char, int>>> cache;
    int minimizeConcatenatedLength(vector<string>& words) {
        return r(words, 1, words[0][0], words[0][words[0].length() - 1], words[0].length());
    }
    int r(vector<string>& words, int i, char first, char second, int l) {
        if (i == words.size()) return l;
        if (cache.find(i) != cache.end() && cache[i].find(first) != cache[i].end() && cache[i][first].find(second) != cache[i][first].end()) return l + cache[i][first][second];
        int front = r(words, i + 1, first, words[i][words[i].length() - 1], (second == words[i][0]) ? l + words[i].length() - 1 : l + words[i].length());
        int back = r(words, i + 1, words[i][0], second, (first == words[i][words[i].length() - 1]) ? l + words[i].length() - 1 : l + words[i].length());
        if (cache.find(i) == cache.end()) {
            unordered_map<char, unordered_map<char, int>> cac;
            cache[i] = cac;
        }
        if (cache[i].find(first) == cache[i].end()) {
            unordered_map<char, int> c;
            cache[i][first] = c;
        }
        cache[i][first][second] = min(front, back) - l;
        return min(front, back);
    }
};
