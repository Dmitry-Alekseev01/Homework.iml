import java.util.Arrays;
import java.util.Scanner;

public class LastEvenNumbers {
    public static void fillArray(int[] array){
        Scanner scan1 = new Scanner(System.in);
        for (int i = 0; i < array.length; ++i){
            System.out.println("Введите элемент: ");
            array[i] = scan1.nextInt();
        }
    }

//    public static void getEvenNumbers(int[] array, int size) {
//        int evencount = 0;
//        for(int i = 0; i < array.length; ++i){
//            if(array[i] % 2 == 0){
//                evencount++;
//            }
//        }
//
//        int[] arrEven = new int[evencount];
//        int index = 0;
//        for (int i = 0; i < array.length; ++i){
//            if(array[i] % 2 == 0){
//                arrEven[index] = array[i];
//                index++;
//            }
//        }
//
//        System.out.println(Arrays.toString(arrEven));
//
//        for (int i = arrEven.length - size; i < arrEven.length; i++){
//            System.out.print(arrEven[i] + " ");
//        }
//    }

    public static void reverseArray(int[] array){
        for (int i = 0; i < array.length/2; ++i){
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }


//    public static int[] getEvenNumbers(int[] array, int size){
//        int[] newArray = new int[size];
//        int k = 0;
//        for (int i = array.length - 1; i >= 0; --i){
//            if (array[i] % 2 == 0){
//                newArray[k] = array[i];
//                k++;
//                if (k == size){
//                    break;
//                }
//            }
//
//        }
//        reverseArray(newArray);
//        return newArray;
//    }

    public static int[] getEvenNumbers(int[] array, int size){
        int[] newArray = new int[size];
        int k = size - 1;
        for (int i = array.length - 1; i >= 0; --i){
            if (array[i] % 2 == 0){
                newArray[k] = array[i];
                k--;
                if (k < 0){
                    break;
                }
            }

        }
        return newArray;
    }


    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = scan1.nextInt();
        int[] array = new int[size];
        fillArray(array);
        System.out.println(Arrays.toString(array));
        System.out.println("Введите количество чётных чисел, из которых составить новый массив: ");
        int evenNumbersCounter = scan1.nextInt();
        int[] evenNumbersArray = getEvenNumbers(array, evenNumbersCounter);
        System.out.println(Arrays.toString(evenNumbersArray));
    }
}
