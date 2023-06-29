class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:
        m, n = len(grid), len(grid[0])
        seen = dict()
        movement = [ [0, 1], [0, -1], [1, 0], [-1, 0]]
        q = []
        moves, keys, locks = 0, 0, 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '@':
                    q.append((0, i, j))
                elif grid[i][j].isalpha():
                    if grid[i][j].islower():
                        keys |= (1 << (ord(grid[i][j]) - ord('a')))
                    else:
                        locks |= (1 << (ord(grid[i][j]) - ord('A')))
        while q:
            l = len(q)
            for i in range(l):
                currKeys, x, y = q.pop(0)
                if currKeys == keys: return moves
                if currKeys in seen:
                    if (x, y) in seen[currKeys]: continue
                else:
                    seen[currKeys] = set()
                seen[currKeys].add((x, y))
                for a, b in movement:
                    nx, ny = x + a, y + b
                    if nx < 0 or ny < 0 or nx >= m or ny >= n: continue
                    if grid[nx][ny] == '#': continue
                    if currKeys in seen and (nx, ny) in seen[currKeys]: continue
                    if grid[nx][ny].isalpha():
                        if grid[nx][ny].isupper():
                            if ((1 << (ord(grid[nx][ny]) - ord('A'))) & currKeys) == 0: continue
                            q.append((currKeys, nx, ny))
                        else:
                            if ((1 << (ord(grid[nx][ny]) - ord('a'))) & currKeys) != 0:
                                q.append((currKeys, nx, ny))
                            else:
                                q.append((((1 << (ord(grid[nx][ny]) - ord('a'))) | currKeys), nx, ny))
                    else:
                        q.append((currKeys, nx, ny))
            moves += 1
        return -1
