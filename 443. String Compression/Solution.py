class Solution:
    def compress(self, chars: List[str]) -> int:
        n, pointer, editPointer = len(chars), 0, 0
        while pointer < n:
            start = pointer
            while pointer < n - 1 and chars[pointer + 1] == chars[pointer]: pointer += 1
            chars[editPointer] = chars[start]
            if pointer - start > 0:
                editPointer += 1
                count, divisor, flag = pointer - start + 1, 1000, False
                while count > 0:
                    if count // divisor > 0:
                        chars[editPointer] = str(count // divisor)
                        if divisor > 1 and count % divisor == 0: flag = True
                        editPointer += 1
                        count -= (count // divisor) * divisor
                    divisor //= 10
                if flag:
                    while divisor > 0:
                        chars[editPointer] = "0"
                        editPointer += 1
                        divisor //= 10
                editPointer -= 1
            pointer += 1
            editPointer += 1
        return editPointer