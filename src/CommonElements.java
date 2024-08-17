import java.util.Arrays;
import java.util.Scanner;

public class CommonElements {
    public static void fillArray(int[] array){
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < array.length; ++i){
            System.out.println("Введите элемент: ");
            array[i] = scan.nextInt();
        }
    }

    public static int[] findCommon(int[] arr1, int[] arr2){
        int size = Math.min(arr1.length, arr2.length);
        int[] res = new int[size];
        int index = 0;
        for(int i = 0; i < arr1.length; ++i){
            for(int j = 0; j < arr2.length; ++j){
                if(arr1[i] == arr2[j]){
                    res[index] = arr1[i];
                    index++;
                }
            }
        }
        res = Arrays.copyOf(res, index);
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер первого массива: ");
        int size = scan.nextInt();
        System.out.println("Введите размер второго массива: ");
        int size2 = scan.nextInt();
        int[] train = new int[size];
        int[] array = new int[size2];
        fillArray(train);
        System.out.println(Arrays.toString(train));
        fillArray(array);
        System.out.println(Arrays.toString(array));
        int[] res = findCommon(train, array);
        System.out.println(Arrays.toString(res));
    }
}
