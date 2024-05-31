class Solution {
public:
    int checkRecord(int n) {
        long long m=1e9+7,aa=1,ab=0,ac=0,ba=0,bb=0,bc=0,ca=0,cb=0,cc=0,da=0,db=0,dc=0;
        for(int i=1;i<=n;i++){
            ca=aa+ab+ac;cb=aa;cc=ab;
            da=ba+bb+bc+ca;db=ba;dc=bb;
            ca%=m;da%=m;
            aa=ca;ab=cb;ac=cc;ba=da;bb=db;bc=dc;
        }
        return (aa+ab+ac+ba+bb+bc)%m;
    }
};
