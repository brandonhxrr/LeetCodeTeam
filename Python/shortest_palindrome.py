class Solution:
    def shortestPalindrome(self, s: str) -> str:
        n = len(s)
        if n <= 1:
            return s

        rev = s[::-1]

        new_s = s + "#" + rev
        new_n = len(new_s)

        lps = [0] * new_n

        def preprocess_lps():
            j = 0
            for i in range(1, new_n):
                while j > 0 and new_s[i] != new_s[j]:
                    j = lps[j - 1]
                if new_s[i] == new_s[j]:
                    j += 1
                lps[i] = j

        preprocess_lps()

        max_left_palindrome_size = lps[new_n - 1]

        left_s = rev[:n - max_left_palindrome_size]

        return left_s + s
