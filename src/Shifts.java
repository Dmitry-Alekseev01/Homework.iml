import java.util.Arrays;
import java.util.Scanner;

public class Shifts {
    public static void fillArray(int[] array){
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < array.length; ++i){
            System.out.println("Введите элемент: ");
            array[i] = scan.nextInt();
        }
    }

//    public static void shiftElements(int[] arr, int n){
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < arr.length - 1; j++){
//                int temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j+1] = temp;
//            }
//        }
//    }

    public static void shiftElements(int[] arr, int n){
        n %= arr.length;
        int[] new_arr = new int[n];
        for(int i = 0; i < new_arr.length; i++){
            new_arr[i] = arr[i];
        }

        for(int i = n; i < arr.length; i++){
            arr[i - n] = arr[i];
        }

        for(int i = arr.length - n, j = 0; i < arr.length; i++, j++){
            arr[i] = new_arr[j];
        }
    }


    public static void shiftRightElements(int[] arr, int n){
        for(int i = 0; i < n; i++){
            int temp = arr[arr.length - 1];
            for(int j = arr.length - 1; j > 0; j--){
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = scan.nextInt();
        int[] arr = new int[size];
        fillArray(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Введите количество вращений: ");
        int n = scan.nextInt();
        shiftElements(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}
