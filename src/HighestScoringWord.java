import java.util.Scanner;

public class HighestScoringWord {
    public static int countWordPower(String word){
        int res = 0;
        for(int i = 0; i < word.length(); i++){
            res += word.charAt(i) - 'a' + 1;
        }
        return res;
    }

    public static String findHighestScore(String s){
        String res = "";
        String[] strings = s.split(" ");
        int max = 0;
        for(int i = 0; i < strings.length; i++){
            int count = countWordPower(strings[i]);
            if(count > max){
                max = count;
                res = strings[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String s = scan.nextLine();
        String res = findHighestScore(s);
        System.out.println(res);
    }
}
