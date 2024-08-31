class Solution {
    boolean validPalindrome(int l, int r, String s) {
        while (l < r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        return l >= r;
    }

    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;

        int maxLeftPalindromeSize = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(0) == s.charAt(i)) {
                if (validPalindrome(0, i, s)) {
                    maxLeftPalindromeSize = i + 1;
                    break;
                }
            }
        }

        int m = n - maxLeftPalindromeSize;
        StringBuilder leftS = new StringBuilder();
        for (int i = 0; i < m; i++) {
            leftS.append(s.charAt(n - 1 - i));
        }

        return leftS.toString() + s;
    }
}