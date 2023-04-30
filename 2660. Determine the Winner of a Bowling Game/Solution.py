class Solution:
    def isWinner(self, player1: List[int], player2: List[int]) -> int:
        n, first, second, firstFlag, secondFlag = len(player1), 0, 0, -1, -1
        for i in range(n):
            first = first + 2 * player1[i] if firstFlag >= 0 and i - firstFlag <= 2 else first + player1[i]
            second = second + 2 * player2[i] if secondFlag >= 0 and i - secondFlag <= 2 else second + player2[i]
            if player1[i] == 10: firstFlag = i
            if player2[i] == 10: secondFlag = i
        return 0 if first == second else 1 if first > second else 2