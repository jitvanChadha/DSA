public class SquaringASortedArray {
    public static void main(String[] args) {
        int[] arr = {-4, -2, -1, 0, 3, 6, 9, 10};

        int[] result = sortedSquares(arr);

        for (int e : result) {
            System.out.print(e + " ");
        }
    }

    // Optimized O(N) Two-Pointer Method
    public static int[] sortedSquares(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        } else {
            int n = nums.length;
            int[] res = new int[n];

            // 1. Square the array in-place
            for (int i = 0; i < n; i++) {
                nums[i] = nums[i] * nums[i];
            }

            int left = 0;
            int right = n - 1;
            int size = n - 1;

            // 2. Populate res array from largest to smallest
            while (right >= left) {
                if (nums[right] > nums[left]) {
                    res[size] = nums[right];
                    right--;
                } else {
                    res[size] = nums[left];
                    left++;
                }
                size--;
            }
            return res;
        }
    }
}