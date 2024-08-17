import java.util.Arrays;
import java.util.Scanner;

public class GameNumbers {
    public static void fillArray(int[] array){
        Scanner scan1 = new Scanner(System.in);
        for (int i = 0; i < array.length; ++i){
            System.out.println("Введите элемент: ");
            array[i] = scan1.nextInt();
        }
    }

    public static void game(int[] arr){
        int score1 = 0;
        int score2 = 0;
        int start = 0;
        int finish = arr.length - 1;
        for(int i = 0; i < arr.length; ++i){
            int max = 0;
            if (arr[start] < arr[finish]){
                max = arr[finish];
                finish--;
            } else {
                max = arr[start];
                start++;
            }

            if(i % 2 == 0){
                score1 += max;
            }
            else {
                score2 += max;
            }
        }

        System.out.println(score1 + ":" + score2);
        //arr = Arrays.copyOf(arr, 3);
    }


    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = scan1.nextInt();
        int[] array = new int[size];
        fillArray(array);
        game(array);
    }
}
