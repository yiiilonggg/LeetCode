class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        n, tracker = len(s), 0
        vowels = set(['A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'])
        for i in range(0, int(n / 2)):
            if s[i] in vowels: tracker += 1
        for i in range(int(n / 2), n):
            if s[i] in vowels: tracker -= 1
        return tracker == 0
            
