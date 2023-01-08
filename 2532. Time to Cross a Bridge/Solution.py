import heapq

class Solution:
    def findCrossingTime(self, n: int, k: int, time: List[List[int]]) -> int:
        leftBank, rightBank, leftWarehouse, rightWarehouse = [], [], [], []
        for i in range(len(time)):
            heapq.heappush(leftBank, [-(time[i][0] + time[i][2]), -i, 0, time[i]])
        currTime = 0
        while n > 0 or rightBank or rightWarehouse:
            if rightBank:
                fromRightBank = heapq.heappop(rightBank)
                currTime += fromRightBank[3][2]
                if n == 0 and not rightBank and not rightWarehouse: return currTime
                fromRightBank[2] = currTime + fromRightBank[3][3]
                heapq.heappush(leftWarehouse, [fromRightBank[2], fromRightBank[0], fromRightBank[1], fromRightBank[3]])
            elif n > 0 and leftBank:
                fromLeftBank = heapq.heappop(leftBank)
                n -= 1
                currTime += fromLeftBank[3][0]
                fromLeftBank[2] = currTime + fromLeftBank[3][1]
                heapq.heappush(rightWarehouse, [fromLeftBank[2], fromLeftBank[0], fromLeftBank[1], fromLeftBank[3]])
            else:
                if rightWarehouse:
                    fromWarehouse = heapq.heappop(rightWarehouse)
                    heapq.heappush(rightBank, [fromWarehouse[1], fromWarehouse[2], fromWarehouse[0], fromWarehouse[3]])
                else:
                    fromWarehouse = heapq.heappop(leftWarehouse)
                    heapq.heappush(leftBank, [fromWarehouse[1], fromWarehouse[2], fromWarehouse[0], fromWarehouse[3]])
                currTime = fromWarehouse[0]
            while leftWarehouse:
                fromLeftWarehouse = heapq.heappop(leftWarehouse)
                if fromLeftWarehouse[0] <= currTime:
                    heapq.heappush(leftBank, [fromLeftWarehouse[1], fromLeftWarehouse[2], fromLeftWarehouse[0], fromLeftWarehouse[3]])
                else:
                    heapq.heappush(leftWarehouse, fromLeftWarehouse)
                    break
            while rightWarehouse:
                fromRightWarehouse = heapq.heappop(rightWarehouse)
                if fromRightWarehouse[0] <= currTime:
                    heapq.heappush(rightBank, [fromRightWarehouse[1], fromRightWarehouse[2], fromRightWarehouse[0], fromRightWarehouse[3]])
                else:
                    heapq.heappush(rightWarehouse, fromRightWarehouse)
                    break
        return -1
            
