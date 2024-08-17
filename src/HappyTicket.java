import java.util.Scanner;

public class HappyTicket {
    public static boolean CheckIsHappy(int ticket){
        int num1 = ticket / 1000;
        int num2 = ticket % 1000;
        int sum1 = 0;
        int sum2 = 0;
        while (num1 != 0 || num2 != 0){
            sum1 += num1 % 10;
            sum2 += num2 % 10;
            num1 /= 10;
            num2 /= 10;
        }
        return sum1 == sum2;

    }

    public static void main(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер билета: ");
        int ticket = scan.nextInt();
        if (CheckIsHappy(ticket)){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
