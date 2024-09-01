public class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;

        String rev = new StringBuilder(s).reverse().toString();
        String new_s = s + "#" + rev;
        int new_n = new_s.length();

        int[] lps = new int[new_n];

        preProcessLPS(new_s, lps);

        int maxLeftPalindromeSize = lps[new_n - 1];
        int m = n - maxLeftPalindromeSize;
        StringBuilder leftS = new StringBuilder();

        for (int i = 0; i < m; i++) {
            leftS.append(s.charAt(n - 1 - i));
        }

        return leftS.toString() + s;
    }

    private void preProcessLPS(String new_s, int[] lps) {
        int j = 0;
        int n = lps.length;
        lps[0] = 0;

        for (int i = 1; i < n; i++) {
            if (new_s.charAt(i) == new_s.charAt(j)) {
                j++;
                lps[i] = j;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                    i--; // to stay at the same index
                } else {
                    lps[i] = 0;
                }
            }
        }
    }
}
