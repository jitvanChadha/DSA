public class QuickSort {

    public static void main(String[] args) {
        int array[] = {10,2,33,4,5,0,23,44,9,3};
        quickSORTas(array,0,array.length-1);
        for ( int i : array){
            System.out.print(i+" ");
        }
    }

    public static void quickSORTas(int arr[], int low, int high) {

        int left = low;
        int right = high;

        int mid = arr[(left + right) / 2];

        while (left <= right) {

            while (arr[left] < mid) {
                left++;
            }

            while (arr[right] > mid) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        if (low < right) {
            quickSORTas(arr, low, right);
        }

        if (left < high) {
            quickSORTas(arr, left, high);
        }
    }

    public static void swap(int arr[], int a, int b) {
        // XOR OPERATION USED HERE (BIT-WISE) WHERE SAME IS 0 and DIFFERENT IS 1 in bits.
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}