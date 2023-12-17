class Pair {
    String s;
    int x;
    Pair(String s, int x) {
        this.s = s;
        this.x = x;
    }
}

class FoodRatings {
    Map<String, Integer> ftor = new HashMap<>();
    Map<String, String> ftoc = new HashMap<>();
    Map<String, PriorityQueue<Pair>> pqs = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int l = foods.length;
        for (int i = 0; i < l; i++) {
            ftor.put(foods[i], ratings[i]);
            ftoc.put(foods[i], cuisines[i]);
            if (!pqs.containsKey(cuisines[i])) pqs.put(cuisines[i], new PriorityQueue<>((a, b) -> (a.x == b.x) ? a.s.compareTo(b.s) : b.x - a.x));
            pqs.get(cuisines[i]).add(new Pair(foods[i], ratings[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        ftor.put(food, newRating);
        pqs.get(ftoc.get(food)).add(new Pair(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        while (ftor.get(pqs.get(cuisine).peek().s) != pqs.get(cuisine).peek().x) {
            pqs.get(cuisine).poll();
        }
        return pqs.get(cuisine).peek().s;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
