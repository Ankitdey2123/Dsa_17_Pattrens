class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            int[] arr = nums.clone();
            boolean sortable = true;

            for (int start = 0; start < n; start += k) {
                int descents = 0;
                int rotate = 0;

                for (int i = start; i < start + k; i++) {
                    int next = start + (i - start + 1) % k;

                    if (arr[i] > arr[next]) {
                        descents++;
                        rotate = (i + 1 - start) % k;
                    }
                }

                if (descents > 1) {
                    sortable = false;
                    break;
                }

                if (descents == 1) {
                    int[] temp = new int[k];

                    for (int i = 0; i < k; i++) {
                        temp[i] = arr[start + (rotate + i) % k];
                    }

                    for (int i = 0; i < k; i++) {
                        arr[start + i] = temp[i];
                    }
                }
            }

            for (int i = 1; i < n; i++) {
                if (arr[i] < arr[i - 1]) {
                    sortable = false;
                    break;
                }
            }

            if (sortable) {
                ans += k;
            }
        }

        return ans;

    }
}