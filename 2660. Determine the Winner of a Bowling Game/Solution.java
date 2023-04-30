class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int n = player1.length, first = 0, second = 0, firstFlag = -1, secondFlag = -1;
        for (int i = 0; i < n; i++) {
            first = (firstFlag >= 0 && i - firstFlag <= 2) ? first + 2 * player1[i] : first + player1[i];
            second = (secondFlag >= 0 && i - secondFlag <= 2) ? second + 2 * player2[i] : second + player2[i];
            if (player1[i] == 10) firstFlag = i;
            if (player2[i] == 10) secondFlag = i;
        }
        return first == second ? 0 : first > second ? 1 : 2;
    }
}