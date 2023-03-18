class BrowserHistory {

    String[] history;
    int curr, high;

    public BrowserHistory(String homepage) {
        history = new String[5001];
        history[0] = homepage;
        curr = 0;
        high = 0;
    }
    
    public void visit(String url) {
        history[++curr] = url;
        high = curr;
    }
    
    public String back(int steps) {
        curr = Math.max(curr - steps, 0);
        return history[curr];
    }
    
    public String forward(int steps) {
        curr = Math.min(high, curr + steps);
        return history[curr];
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */