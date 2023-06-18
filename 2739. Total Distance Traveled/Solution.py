class Solution:
    def distanceTraveled(self, mainTank: int, additionalTank: int) -> int:
        dist = 0
        while mainTank > 0:
            dist += min(5, mainTank) * 10
            mainTank -= 5
            if mainTank >= 0 and additionalTank > 0:
                mainTank += 1
                additionalTank -= 1
        return dist
