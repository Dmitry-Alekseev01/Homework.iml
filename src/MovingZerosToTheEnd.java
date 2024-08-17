import java.util.Arrays;
import java.util.Scanner;

public class MovingZerosToTheEnd {
    public static void fillArray(int[] array){
        Scanner scan1 = new Scanner(System.in);
        for (int i = 0; i < array.length; ++i){
            array[i] = scan1.nextInt();
        }
    }

//    public static void moveZeroes(int[] array){
//        for (int i = 0; i < array.length; ++i){
//            if (array[i] == 0){
//                for (int j = i; j < array.length - 1; ++j){
//                    array[j] = array[j+1];
//                }
//                array[array.length - 1] = 0;
//            }
//        }
//    }

    public static void moveZeroes(int[] array){
        int k = 0;
        for (int i = 0; i < array.length; ++i){
            if (array[i] != 0){
                array[k] = array[i];
                ++k;
            }
        }
        for (int j = k; j < array.length; ++j){
            array[j] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = scan.nextInt();
        int[] arr = new int[size];
        fillArray(arr);
        System.out.println(Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
