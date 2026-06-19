import java.util.Scanner;

public class MovingAverage {

    public static void main(String[] args) {

        int arr[] = {41, 42, 44, 42, 42, 41, 44, 45, 40, 39};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        float[] movingAvgArray = MAVcalc(arr, k);

        System.out.println("Moving Averages:");
        for (float avg : movingAvgArray) {
            System.out.print(avg + " ");
        }
    }

    static float[] MAVcalc(int arr[], int k) {

        int size = arr.length - k + 1;
        float[] movingAvgArray = new float[size];

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (i >= k) {
                sum -= arr[i - k];
            }

            if (i >= k - 1) {
                movingAvgArray[i - k + 1] = (float) sum / k;
            }
        }

        return movingAvgArray;
    }
}