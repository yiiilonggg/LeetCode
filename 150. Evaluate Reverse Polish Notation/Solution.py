class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        operations = {
            '+': lambda x, y: x + y,
            '-': lambda x, y: x - y,
            '*': lambda x, y: x * y,
            '/': lambda x, y: int(x / y)
        }
        for token in tokens:
            if token in operations:
                first, second = stack.pop(), stack.pop()
                stack.append(operations[token](second, first))
            else:
                stack.append(int(token))
        return stack[0]
