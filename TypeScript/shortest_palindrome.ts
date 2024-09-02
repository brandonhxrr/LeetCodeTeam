function shortestPalindrome(s: string): string {
    const n = s.length;
    if (n <= 1) return s;

    const rev = s.split('').reverse().join('');
    const new_s = s + '#' + rev;
    const new_n = new_s.length;

    const lps = new Array(new_n).fill(0);

    // Lambda function for preprocessing LPS
    const preProcessLPS = () => {
        let j = 0;
        lps[0] = 0;

        for (let i = 1; i < new_n; i++) {
            if (new_s[i] === new_s[j]) {
                j++;
                lps[i] = j;
            } else {
                if (j !== 0) {
                    j = lps[j - 1];
                    i--; // to stay at the same index
                } else {
                    lps[i] = 0;
                }
            }
        }
    };

    preProcessLPS();

    const maxLeftPalindromeSize = lps[new_n - 1];
    const m = n - maxLeftPalindromeSize;
    let leftS = '';

    for (let i = 0; i < m; i++) {
        leftS = leftS + s[n - 1 - i];
    }

    return leftS + s;
};