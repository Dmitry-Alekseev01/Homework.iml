import java.util.Random;
import java.util.Scanner;

public class CheckMultiplicationTable {
    public static int markCounter(int N, int countCorrect){
        int mark = 0;
        double correctPercent = (1. * countCorrect / N) * 100;
        if (correctPercent >= 90){
            mark = 5;
        }
        else if(correctPercent < 90 && correctPercent >= 75){
            mark = 4;
        }
        else if(correctPercent < 75 && correctPercent >= 60){
            mark = 3;
        }
        else {
            mark = 2;
        }
        return mark;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество примеров: ");
        int N = scan.nextInt();
        //taskGenerator(N);
        int countCorrect = 0;
        Random random = new Random();
        Scanner scan1 = new Scanner(System.in);
        for (int i = 0; i < N; ++i){
            int firstNumber = random.nextInt(11);
            int secondNumber = random.nextInt(11);
            System.out.println(STR."\{firstNumber} * \{secondNumber} = ");
            System.out.println("Введите свой ответ: ");
            int userAnswer = scan1.nextInt();
            if (userAnswer == firstNumber * secondNumber){
                countCorrect += 1;
                System.out.println("Correct");
            } else{
                System.out.println("Incorrect");
            }
        }
        int mark = markCounter(N, countCorrect);
        System.out.println(STR."Mark: \{mark}");
    }
}
