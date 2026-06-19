import java.util.Random;
public class practice {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6};
        Random random = new Random();
        while (true) {
            int i = random.nextInt(10);
            int j = random.nextInt(10);

            if (i != j && array[i] == array[j]) {
                System.out.println("Match found: " + array[i]);
                break;
            }
        }
    }
}