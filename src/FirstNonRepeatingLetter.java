import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeatingLetter {
    public static String firstNonRepeatingLetter(String s){
        String res = "";
        HashMap<Character, Integer> frequency = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = Character.toLowerCase(s.charAt(i));
            if(frequency.containsKey(c)){
                frequency.replace(c, frequency.get(c) + 1);
            } else {
                frequency.put(c, 1);
            }
        }

        for(int i = 0; i < s.length(); i++){
            char newS = Character.toLowerCase(s.charAt(i));
            if(frequency.get(newS) == 1){
                return s.charAt(i) + " ";
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите слово: ");
        String s = scan.next();
        String res = firstNonRepeatingLetter(s);
        System.out.println(res);
    }
}
