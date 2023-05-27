class Solution:
    def buyChoco(self, prices: List[int], money: int) -> int:
        first, second = 101, 101
        for p in prices:
            if p < first:
                second, first = first, p
            elif p < second:
                second = p
        return money if (money < first + second) else money - (first + second)
