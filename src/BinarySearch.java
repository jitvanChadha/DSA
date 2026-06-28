import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.print("Enter the Key value that you want to search: ");
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        int[] a = {1, 2, 5, 6, 7, 99, 105, 334, 4344, 9099, 10000, 23233, 232320};
        int low = 0;
        int high = a.length - 1;

        // Capture and print the result
        int result = BinarySearchAlgo(a, low, high, key);
        if (result != -1) {
            System.out.println("Key found at index: " + result);
        } else {
            System.out.println("Key not found in the array.");
        }
        scanner.close();
    }

    public static int BinarySearchAlgo(int[] a, int low, int high, int key) {
        if (low > high) {
            return -1;
        }

        // INTERVIEW NOTE: See Question 2 in the comments below about integer overflow
        int mid = (low + high) / 2;

        System.out.println("The value of low and high at this step : " + low + " & " + high );
        if (key > a[mid]) {
            return BinarySearchAlgo(a, mid + 1, high, key);
        } else if (key < a[mid]) {
            return BinarySearchAlgo(a, low, mid - 1, key);
        } else {
            return mid;
        }
    }
}

/*******************************************************************************
 * CRITICAL INTERVIEW QUESTIONS & CONCEPTS FOR BINARY SEARCH
 *******************************************************************************
 *
 * 1. TIME & SPACE COMPLEXITY
 * - Time Complexity: Best Case: O(1) if the key is right at the first mid.
 * Worst/Average Case: O(log N) because the search space
 * is halved at every single step.
 * - Space Complexity:
 * - Recursive version (this code): O(log N) due to the call stack frames.
 * - Iterative version (using a while loop): O(1) constant auxiliary space.
 * - Tip: Interviewers usually prefer the Iterative version to save memory!
 *
 * 2. THE BIGGEST BUG IN BINARY SEARCH: INTEGER OVERFLOW
 * - Question: What is wrong with "int mid = (low + high) / 2;"?
 * - Answer: If 'low' and 'high' are both very large positive numbers (close
 * to Integer.MAX_VALUE), adding them together can exceed 2,147,483,647.
 * This causes integer overflow, turning the sum negative, and leads to an
 * ArrayIndexOutOfBoundsException.
 * - Fix: Replace it with:
 * int mid = low + (high - low) / 2;
 * Or use the unsigned bitwise right-shift operator:
 * int mid = (low + high) >>> 1;
 *
 * 3. PREREQUISITE OF BINARY SEARCH
 * - Question: Can you apply Binary Search to any array?
 * - Answer: No. The array *must* be strictly sorted. If it isn't sorted,
 * you must sort it first (which takes O(N log N) time) or use Linear Search.
 *
 * 4. FREQUENT INTERVIEW VARIATIONS (LeetCode Favorites)
 * - Search in Rotated Sorted Array (LeetCode 33): Array is sorted but shifted
 * at a pivot (e.g., [4,5,6,7,0,1,2]). You must find which half is normally sorted.
 * - Find First and Last Position of Element (LeetCode 34): If duplicates exist,
 * modify the condition to keep searching left/right even after finding the key.
 * - Search Insert Position (LeetCode 35): If the key isn't found, returning
 * the 'low' pointer gives you the exact index where it *should* be inserted.
 *
 * 5. ADVANCED TALKING POINT: "BINARY SEARCH ON ANSWER"
 * - Tell the interviewer that Binary Search is not just for arrays. It can be
 * used to find an optimal value within a range of integers if the solution space
 * is monotonic (meaning if X works, everything greater than X works too).
 * Examples: LeetCode 875 (Koko Eating Bananas), LeetCode 410 (Split Array Largest Sum).
 *******************************************************************************/