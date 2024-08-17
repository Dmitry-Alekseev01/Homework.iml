import java.util.Arrays;
import java.util.Scanner;

public class CentralElement {
    public static void fillArray(int[] array){
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < array.length; ++i){
            System.out.println("Введите элемент: ");
            array[i] = scan.nextInt();
        }
    }

//    public static int findCentralElement(int[] arr){
//        int index = 0;
//
//        for (int i = 1; i < arr.length - 1; ++i){
//
//            int leftsum = 0;
//            int rightsum = 0;
//
//            for (int j = 0; j < i; ++j) {
//                leftsum += arr[j];
//            }
//
//            for (int k = i + 1; k < arr.length; ++k){
//                rightsum += arr[k];
//            }
//
//            if (leftsum == rightsum){
//                index = i;
//                return index;
//            }
//        }
//        return -1;
//    }

    public static int findCentralElement(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; ++i){
            sum += arr[i];
        }

        int leftsum = 0;
        for (int i = 0; i < arr.length; ++i){
            sum -= arr[i];
            if(sum == leftsum){
                return i;
            }
            leftsum += arr[i];
        }
        return -1;
    }



    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = scan1.nextInt();
        int[] array = new int[size];
        fillArray(array);
        System.out.println(Arrays.toString(array));
        int index = findCentralElement(array);
        if (index != -1){
            System.out.println("Индекс центрального элемента: " + index);
        }
        else{
            System.out.println("Такого элемента нет.");
        }

    }
}
