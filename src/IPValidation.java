import java.util.Scanner;

public class IPValidation {
    public static boolean checkNumber(String s){
        try{
            Integer.parseInt(s);
        } catch(Exception ex){
            return false;
        }
        return true;
    }

    private static boolean checkPart(String s){
        if(!checkNumber(s) || (s.startsWith("0") && Integer.parseInt(s) != 0)) {
            return false;
        }
        int part = Integer.parseInt(s);
        return part >= 0 && part <= 255;
    }

    public static boolean checkIP(String s){
        String[] strings = s.split("\\.");
        if(strings.length != 4){
            return false;
        }
        for(int i = 0; i < strings.length; i++){
            if(!checkPart(strings[i]) ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите IP-адресс: ");
        String s = scan.next();
        if(checkIP(s)){
            System.out.println("Адресс корректный.");
        }
        else{
            System.out.println("Адресс некорректный.");
        }
    }
}
