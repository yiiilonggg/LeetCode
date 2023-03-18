class Solution {
    public int distMoney(int money, int children) {
        if (children > money) return -1;
        int high = children * 8;
        if (high < money) return children - 1;
        if (high == money) return children;
        if (high - money == 4) return children - 2;
        children -= (high - money) / 7;
        return ((high - money) % 7 == 0) ? children : children - 1;
    }
}