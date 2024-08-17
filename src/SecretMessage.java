import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SecretMessage {
    public static boolean findBaseNumber(String message, int length){
        int messageLength = message.length();
        HashSet<String> numberCount = new HashSet<>();
        for(int i = 0; i <= messageLength - length; i++){
            String substr = message.substring(i, i+length);
//            numberCount.put(substr, numberCount.getOrDefault(substr, 0) + 1);
            if(numberCount.contains(substr)){
                return true;
            }
            else{
                numberCount.add(substr);
            }
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("message.txt"));
        int messageLength = scan.nextInt();
        int cipherLength = scan.nextInt();
        String message = scan.next();
        if(findBaseNumber(message, cipherLength)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
