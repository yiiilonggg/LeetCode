class Solution {
public:
    int distanceTraveled(int mainTank, int additionalTank) {
        int dist = 0;
        while (mainTank > 0) {
            dist += min(5, mainTank) * 10;
            mainTank -= 5;
            if (mainTank >= 0 && additionalTank > 0) {
                mainTank++;
                additionalTank--;
            }
        }
        return dist;
    }
};
