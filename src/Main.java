import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static double calcBMI(double weight, double height){
        height /= 100;
        return weight/(height * height);
    }

    public static void printBMI(double BMI){
        if (BMI < 18.5){
            System.out.println("Underweight");
        }
        else if (BMI < 25.0){
            System.out.println("Normal weight");
        }
        else if (BMI < 30.0){
            System.out.println("Overweight");
        }
        else {
            System.out.println("Obesity");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите вес: ");
        double weight = scan.nextDouble();
        System.out.println("Введите рост: ");
        double height = scan.nextDouble();
        double BMI = calcBMI(weight, height);
        printBMI(BMI);
    }
}