class Solution:
    def distMoney(self, money: int, children: int) -> int:
        if children > money: return -1
        high = children * 8
        if high < money: return children - 1
        if money == high: return children
        if high - money == 4: return children - 2
        children -= (high - money) // 7
        return children if (high - money) % 7 == 0 else children - 1