class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        l = len(flowerbed)
        if n == 0 or l == 1: return flowerbed[0] == 0 or n == 0
        if flowerbed[0] == 0 and flowerbed[1] == 0:
            n -= 1
            flowerbed[0] = 1
        if flowerbed[-1] == 0 and flowerbed[-2] == 0:
            n -= 1
            flowerbed[-1] = 1
        for i in range(1, l - 1):
            if flowerbed[i] == 1: continue
            if flowerbed[i - 1] == 0 and flowerbed[i + 1] == 0:
                n -= 1
                flowerbed[i] = 1
            if n <= 0: break
        return n <= 0