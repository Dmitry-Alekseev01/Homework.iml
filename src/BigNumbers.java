import java.util.Arrays;
import java.util.Scanner;

public class BigNumbers {
    public static void fillArray(int[] array) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < array.length; ++i) {
            System.out.println("Введите элемент: ");
            array[i] = scan.nextInt();
        }
    }

    public static int[] findBigNumbers(int[] arr) {
        int max = Integer.MIN_VALUE;
        int[] res = new int[arr.length];
        int index = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                res[index] = max;
                index++;
            }
        }
        res = Arrays.copyOf(res, index);


        for (int i = 0; i < res.length / 2; ++i) {
            int temp = res[i];
            res[i] = res[res.length - 1 - i];
            res[res.length - 1 - i] = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = scan.nextInt();
        int[] arr = new int[size];
        fillArray(arr);
        System.out.println(Arrays.toString(arr));
        int[] res = findBigNumbers(arr);
        System.out.println(Arrays.toString(res));
    }
}
