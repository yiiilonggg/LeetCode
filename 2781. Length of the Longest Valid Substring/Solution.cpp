class Solution {
public:
    struct Trie {
        vector<Trie*> neighbours;
        bool end;

        Trie() {
            neighbours.assign(26, nullptr);
            end = false;
        }
    };
    
    Trie* root = new Trie();

    void insert(string &w) {
        Trie* curr = root;
        for (char c : w) {
            if (curr -> neighbours[c - 'a'] == nullptr) curr -> neighbours[c - 'a'] = new Trie();
            curr = curr -> neighbours[c - 'a'];
        }
        curr -> end = true;
    }

    bool search(string& w, int left, int right) {
        Trie* curr = root;
        for (int i = left; i <= right; i++) {
            if (curr -> neighbours[w[i] - 'a'] == nullptr) return false;
            curr = curr -> neighbours[w[i] - 'a'];
            if (curr -> end) return true;
        }
        return false;
    }

    int longestValidSubstring(string word, vector<string>& forbidden) {
        for (auto& f : forbidden) insert(f);
        int n = word.length(), res = 0, right = n -1;
        for (int left = n - 1; left >= 0; left--) {
            while (left <= right && search(word, left, right)) right--;
            res = max(res, right - left + 1);
        }
        return res;
    }
};
