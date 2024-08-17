import java.util.Arrays;
import java.util.Scanner;

public class Train {
    public static void fillArray(int[] array){
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < array.length; ++i){
            System.out.println("Введите элемент: ");
            array[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество вагонов в поезде: ");
        int size = scan.nextInt();
        int[] train = new int[size];
        fillArray(train);
        System.out.println(Arrays.toString(train));
        int sum = 0;
        for (int i = 0; i < train.length; ++i){
            sum += train[i];
        }
        System.out.println("Количество пассажиров: " + sum);
    }
}
