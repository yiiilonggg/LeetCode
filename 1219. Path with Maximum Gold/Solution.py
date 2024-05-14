class Solution:
    def getMaximumGold(self, grid: List[List[int]]) -> int:
        ds=[(0,1),(0,-1),(1,0),(-1,0)]
        m,n,r=len(grid),len(grid[0]),0
        def dfs(c,i,j,s,r):
            r=max(r,c)
            for x,y in ds:
                ni,nj=i+x,j+y
                if ni<0 or ni>=m or nj<0 or nj>=n or not grid[ni][nj] or (ni,nj) in s:continue
                s.add((ni,nj))
                r=max(r,dfs(c+grid[ni][nj],ni,nj,s,r))
                s.remove((ni,nj))
            return r
        for i in range(m):
            for j in range(n):
                if grid[i][j]: r=dfs(grid[i][j], i, j, {(i, j)},r)
        return r
