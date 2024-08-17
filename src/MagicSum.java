import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void fillArray(int[] array){
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < array.length; ++i){
            System.out.println("Введите элемент: ");
            array[i] = scan.nextInt();
        }
    }

    public static void findMagicSums(int[] arr, int number){
        for(int i = 0; i < arr.length; ++i){
            for (int j = i + 1; j < arr.length; ++j){
                if (arr[i] != arr[j] && (arr[i] + arr[j] == number)){
                    System.out.println(arr[i] + " " + arr[j]);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = scan.nextInt();
        int[] arr = new int[size];
        fillArray(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Введите число - магическую сумму: ");
        int n = scan.nextInt();
        findMagicSums(arr, n);
    }
}
