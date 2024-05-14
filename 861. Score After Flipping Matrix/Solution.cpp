class Solution {
public:
    int matrixScore(vector<vector<int>>& grid) {
        int m=grid.size(),n=grid[0].size(),r=0;
        for(int i=0;i<m;i++){
            if(!grid[i][0]){
                for(int j=0;j<n;j++)grid[i][j]=!grid[i][j];
            }
        }
        for(int i=0;i<n;i++){
            int a=0,b=0;
            for(int j=0;j<m;j++){
                if(grid[j][i]){
                    a++;
                }else{
                    b++;
                }
            }
            r+=(1<<(n-i-1))*max(a,b);
        }
        return r;
    }
};
