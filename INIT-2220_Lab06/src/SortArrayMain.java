import java.util.Arrays;
import java.util.Random;

public class SortArrayMain {
    public static void main(String[] args) {
        Random random = new Random();
        int n = 25;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println("The original array is: ");
        System.out.println(Arrays.toString(arr));

        SortArray.selectionSort(arr, n);
        System.out.println("The new array is: ");
        System.out.println(Arrays.toString(arr));

    }
}