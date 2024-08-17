import java.util.Arrays;
import java.util.Scanner;

public class TopFiveMin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = scan.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; ++i){
            arr[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < arr.length; ++i){
            System.out.println("Введите число: ");
            arr[i] = scan.nextInt();
            Arrays.sort(arr);
            int finish;
            if (i + 1 < 5) {
                finish = i + 1;
            }
            else {
                finish = 5;
            }

            for (int j = finish - 1; j >= 0; --j){
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }
}
