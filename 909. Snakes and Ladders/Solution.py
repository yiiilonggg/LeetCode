class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        self.n = len(board)
        visited = [False for i in range(self.n * self.n + 1)]
        q = [1]
        moves = 0
        while q:
            l = len(q)
            for i in range(l):
                curr = q.pop(0)
                if visited[curr]: continue
                visited[curr] = True
                if curr == self.n * self.n: return moves
                for i in range(min(self.n * self.n, curr + 6), curr, -1):
                    j = i
                    val = self.getVal(board, j)
                    if val > 0: j = val
                    if not visited[j]: q.append(j)
            moves += 1
        return -1

    def getVal(self, board, num):
        r = (num - 1) // self.n
        x = self.n - 1 - r
        y = num - 1 - r * self.n if r % 2 == 0 else self.n + r * self.n - num
        return board[x][y]