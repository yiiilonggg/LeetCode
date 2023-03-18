class BrowserHistory:

    def __init__(self, homepage: str):
        self.history = ["" for i in range(5001)]
        self.history[0] = homepage
        self.curr, self.high = 0, 0
        

    def visit(self, url: str) -> None:
        self.curr += 1
        self.history[self.curr] = url
        self.high = self.curr

    def back(self, steps: int) -> str:
        self.curr = max(self.curr - steps, 0)
        return self.history[self.curr]

    def forward(self, steps: int) -> str:
        self.curr = min(self.curr + steps, self.high)
        return self.history[self.curr]


# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)