class Solution {
public:
    vector<int> p(string&t,unordered_map<char,int>&c,vector<int>&s){
        int b=1,r=0;
        for(auto l:t){
            c[l]--;
            if(c[l]<0)b=0;
        }
        if(!b){
            for(auto l:t)c[l]++;
        }else{
            for(auto l:t)r+=s[l-'a'];
        }
        return {r,b};
    }
    int r(vector<string>&w,unordered_map<char,int>&c,vector<int>&s,int q,int i){
        if(i==w.size())return q;
        int h=q;
        for(int j=i;j<w.size();j++){
            auto pr=p(w[j],c,s);
            if(pr[1]){
                h=max(h,r(w,c,s,q+pr[0],j+1));
                for(auto l:w[j])c[l]++;
            }
        }
        return h;
    }
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        unordered_map<char,int>c;
        for(auto l:letters)c[l]++;
        int h=0;
        for(int i=0;i<words.size();i++)h=max(h,r(words,c,score,0,i));
        return h;
    }
};
