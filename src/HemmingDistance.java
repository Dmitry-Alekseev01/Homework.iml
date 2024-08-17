import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HemmingDistance {
    public static int countHemming(String message, String userMessage){
        int count = 0;
        if(message.length() != userMessage.length()){
            return -1;
        }
        for(int i = 0; i < message.length(); i++){
            if(userMessage.charAt(i) != message.charAt(i)){
                count++;
            }
        }
        return count;
    }

//    public static int countMinHemmingDistance(String message, ArrayList<String> messages){
//        int minHemmingDistance = Integer.MAX_VALUE;
//        for(int i = 0; i < messages.size(); i++){
//            int newHemming = countHemming(message, messages.get(i));
//            if(newHemming < minHemmingDistance) {
//                minHemmingDistance = newHemming;
//            }
//        }
//        return minHemmingDistance;
//    }

    public static ArrayList<Integer> countMessages(String message, ArrayList<String> messages){
        ArrayList<Integer> indexes = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < messages.size(); i++){
            int hemming = countHemming(message, messages.get(i));
            if(hemming < min){
                min = hemming;
                indexes.clear();
            }
            if(min == hemming){
                indexes.add(i + 1);
            }
        }
        return indexes;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("hemming.txt"));
        String message = scan.next();
        int messagesCount = scan.nextInt();
        ArrayList<String> messages = new ArrayList<>();
        for(int i = 0; i < messagesCount; i++){
            String inputMessage = scan.next();
            messages.add(inputMessage);
        }
        ArrayList<Integer> minLengthMessages = countMessages(message, messages);
        System.out.println(minLengthMessages.size());
        System.out.println(minLengthMessages);
    }
}
