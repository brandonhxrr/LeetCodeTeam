class Solution:
    def valid_palindrome(self, l: int, r: int, s: str) -> bool:
        while(l < r and s[l] == s[r]):
            l = l + 1
            r = r - 1

        return not (l < r)
        
    def shortestPalindrome(self, s: str) -> str:
        n = len(s)

        if n <= 1:
            return s

        max_left_palindrome_size = 1

        for i in range(n-1, -1, -1):
            if s[0] == s[i] and self.valid_palindrome(0, i, s):
                max_left_palindrome_size = i + 1
                break

        m = n - max_left_palindrome_size

        left_s = ""

        for i in range(0, m):
            left_s = left_s + s[n - 1 - i]

        return left_s + s