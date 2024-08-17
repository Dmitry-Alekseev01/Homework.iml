import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SumConsecutives {
    public static void fillArray(int[] array){
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < array.length; ++i){
            System.out.println("Введите элемент: ");
            array[i] = scan.nextInt();
        }
    }

    public static ArrayList<Integer> findConsecutives(int[] arr){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int current = arr[0];
        int sum = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == current){
                sum += arr[i];
            } else {
                result.add(sum);
                current = arr[i];
                sum = arr[i];
            }
        }
        result.add(sum);
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = scan.nextInt();
        int[] arr = new int[size];
        fillArray(arr);
        System.out.println(Arrays.toString(arr));
        ArrayList<Integer> res = findConsecutives(arr);
        System.out.println(res);
    }
}
