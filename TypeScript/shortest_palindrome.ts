function shortestPalindrome(s: string): string {
    const n = s.length;
    if(n<=1) return s;

    const validPalindrome = (l: number, r: number): boolean => {
        while(l<r && s[l]==s[r]){
            l++;
            r--;
        }
        return !(l<r);
    };

    let maxLeftPalindromeSize = 1;

    for(let i=n-1; i>=0; i--){
        if(s[0] == s[i]){
            if(validPalindrome(0,i)){
                maxLeftPalindromeSize = i+1;
                break;
            }
        }
    }

    const m = n-maxLeftPalindromeSize;
    let leftS = '';

    for(let i=0; i<m; i++){
        leftS = leftS + s[n-1-i];
    }

    return leftS + s;
};