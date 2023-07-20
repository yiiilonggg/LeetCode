class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack, res = [], []
        for a in asteroids:
            if a < 0:
                while stack and stack[-1] < -a: stack.pop()
                if stack and stack[-1] == -a:
                    stack.pop()
                elif not stack:
                    res.append(a)
            else:
                stack.append(a)
        return res + stack
