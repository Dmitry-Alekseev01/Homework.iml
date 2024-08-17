import java.util.Scanner;

public class CamelCasing {
    public static String camelCase(String input){
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(Character.isUpperCase(c)){
                input = input.substring(0, i) + " " + input.substring(i);
                i++;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите слово: ");
        String s = scan.next();
        String res = camelCase(s);
        System.out.println(res);
    }
}
