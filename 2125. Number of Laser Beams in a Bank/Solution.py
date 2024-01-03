class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        c,p=0,0
        bs=[b.count('1') for b in bank]
        for b in bs:
            if b==0:continue
            c+=p*b
            p=b
        return c
