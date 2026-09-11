class Solution {
    public int totalNumbers(int[] digits) {
int count = 0;

        int[] freq = new int[10];

        // Count frequency of every digit
        for (int digit : digits) {
            freq[digit]++;
        }

        // Choose the last digit (must be even)
        for (int last = 0; last <= 8; last += 2) {

            if (freq[last] == 0) {
                continue;
            }

            freq[last]--;

            // Choose the first digit (cannot be 0)
            for (int first = 1; first <= 9; first++) {

                if (freq[first] == 0) {
                    continue;
                }

                freq[first]--;

                // Choose the middle digit
                for (int middle = 0; middle <= 9; middle++) {

                    if (freq[middle] > 0) {
                        count++;
                    }
                }

                // Put first digit back
                freq[first]++;
            }

            // Put last digit back
            freq[last]++;
        }

        return count;
    }
}