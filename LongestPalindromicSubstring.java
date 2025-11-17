class Prep {

    static void findLongestPalindromicString(String text) {

        int N = text.length();
        if (N == 0)
            return;

        N = 2 * N + 1; // total number of positions
        int[] L = new int[N + 1];
        L[0] = 0;
        L[1] = 1;

        int C = 1;  // center
        int R = 2;  // right boundary
        int i, iMirror;

        int maxLPSLength = 0;
        int maxLPSCenterPosition = 0;

        int start = -1;
        int end = -1;

        for (i = 2; i < N; i++) {

            // Mirror of i around center C
            iMirror = 2 * C - i;
            L[i] = 0;

            int diff = R - i;

            if (diff > 0)
                L[i] = Math.min(L[iMirror], diff);

            // Expand around center i
            while ((i + L[i]) + 1 < N &&
                   (i - L[i]) > 0 &&
                   (((i + L[i] + 1) % 2 == 0) ||
                   (text.charAt((i + L[i] + 1) / 2) ==
                    text.charAt((i - L[i] - 1) / 2)))) {

                L[i]++;
            }

            // Update center and right boundary
            if (i + L[i] > R) {
                C = i;
                R = i + L[i];
            }

            // Track longest palindrome
            if (L[i] > maxLPSLength) {
                maxLPSLength = L[i];
                maxLPSCenterPosition = i;
            }
        }

        start = (maxLPSCenterPosition - maxLPSLength) / 2;
        end = start + maxLPSLength - 1;

        System.out.println("Longest Palindromic Substring: " + text.substring(start, end + 1));
    }

    public static void main(String[] args) {
        String text = "abcbabccba";
        findLongestPalindromicString(text);
    }
}
