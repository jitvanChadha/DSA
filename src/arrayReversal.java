public class arrayReversal {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6};
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j >= 0; j--) {
                if (i == j || i > j) {
                    break;
                } else {
                    arr2[i] = arr[j];
                }
            }
        }
        for (int m = 0; m < arr.length; m++) {
            System.out.print(arr2[m] + " ");
        }
        System.out.println(" ");
        for (int n = 0; n < arr.length; n++) {
            System.out.print(arr[n] + " ");
        }
    }
}
