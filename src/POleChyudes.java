import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Question {
    private String name;
    private String answer;

    public Question(String name, String answer) {
        this.name = name;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public String getAnswer() {
        return answer;
    }
}

class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        score += points;
    }
}

public class POleChyudes {
    public static ArrayList<Player> createPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите имя игрока: ");
            String name = scan.next();
            Player player = new Player(name);
            players.add(player);
        }
        return players;
    }

    public static ArrayList<Question> readQuestions() throws IOException {
        ArrayList<Question> questions = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("questions.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String answer = reader.readLine().toLowerCase();
            Question question = new Question(line, answer);
            questions.add(question);
        }
        reader.close();
        return questions;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Question> questions = readQuestions();
        ArrayList<Player> players = createPlayers();
        Random rand = new Random();
        int number = rand.nextInt(0, questions.size());
        Question question = questions.get(number);
        System.out.println(question.getName());
        String word = "#".repeat(question.getAnswer().length());
        String answer = question.getAnswer();
        int playerNumber = 0;

        while (true) {
            String playerName = players.get(playerNumber).getName();
            System.out.println("Ходит игрок по имени " + playerName);
            System.out.println(word);
            System.out.println("1 - Крутите барабан");
            System.out.println("2 - Введите слово целиком");
            int choice = scan.nextInt();
            if (choice == 1) {
                int points = rand.nextInt(1, 21) * 50;
                System.out.println("У вас выпало " + points + " очков");
                System.out.println("Введите букву: ");
                char c = scan.next().charAt(0);
                int count = 0;
                while(word.contains(c + "")){
                    System.out.println("Такая буква уже есть, введите другую: ");
                     c = scan.next().charAt(0);
                }
                if (answer.contains(c + "")) {
                    System.out.println("Такая буква есть.");
                    for (int i = 0; i < answer.length(); i++) {
                        if (answer.charAt(i) == c) {
                            word = word.substring(0, i) + c + word.substring(i + 1);
                            count++;
                        }
                    }
                    players.get(playerNumber).addScore(points * count);
                    System.out.println("Игрок " + playerName + " получил " + players.get(playerNumber).getScore());
                    if (!word.contains("#")) {
                        System.out.println("Игрок " + playerName + " отгадал слово и выиграл");
                        break;
                    }
                } else {
                    playerNumber++;
                    playerNumber %= players.size();
                }
            } else if (choice == 2) {
                String userAnswer = scan.next();
                if(userAnswer.equals(answer)){
                    System.out.println("Игрок " + playerName + " отгадал слово и выиграл");
                    break;
                }
                else {
                    System.out.println("Игрок " + playerName + " не отгадал слово. Ход переходит к следующему игроку.");
                    playerNumber++;
                    playerNumber %= players.size();
                }
            }
            else {
                System.out.println("Такой команды нет.");
            }
        }
    }
}


