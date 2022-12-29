class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack();
        Set<String> operators = new HashSet<>(List.of("+", "-", "*", "/"));
        for (String token : tokens) {
            if (operators.contains(token)) {
                int first = s.pop(), second = s.pop();
                s.push(operations(second, first, token));
            } else {
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }
    public int operations(int x, int y, String operator) {
        switch (operator) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            default:
                return (int) x / y;
        }
    }
}
