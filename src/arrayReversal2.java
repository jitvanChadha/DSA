public class arrayReversal2 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6};
        int[] arr2 = new int[arr.length];
        for ( int i = 0 ; i<= arr.length-1 ; i++){
            arr2[i] = arr[arr.length-1-i];
            System.out.print(arr2[i]+" ");
        }
    }
}
