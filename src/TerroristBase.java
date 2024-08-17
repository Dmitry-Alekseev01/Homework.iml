import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TerroristBase {
    public static boolean checkPlace(char[][] matrixExample, char[][] matrixDesert, int row, int col){
        for(int i = row, rowExample = 0; i < row + matrixExample.length; i++, rowExample++){
            for(int j = col, colExample = 0; j < col + matrixExample[0].length; j++, colExample++){
                if(matrixDesert[i][j] != matrixExample[rowExample][colExample]){
                    if(matrixExample[rowExample][colExample] == '.' && matrixDesert[i][j] == '#'){
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int calcPossiblePlaces(char[][] matrixExample, char[][] matrixDesert){
        int count = 0;
        for(int i = 0; i < matrixDesert.length - matrixExample.length + 1; i++){
            for(int j = 0; j < matrixDesert[0].length - matrixExample[0].length + 1; j++){
                if (checkPlace(matrixExample, matrixDesert, i, j)){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("input2.txt"));
        int n = scan.nextInt();
        int m = scan.nextInt();
        char[][] matrixExample = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = scan.next();
            for (int j = 0; j < m; j++) {
                matrixExample[i][j] = s.charAt(j);
            }
        }
        int n1 = scan.nextInt();
        int m1 = scan.nextInt();
        char[][] matrixDesert = new char[n1][m1];
        for (int i = 0; i < n1; i++) {
            String s = scan.next();
            for (int j = 0; j < m1; j++) {
                matrixDesert[i][j] = s.charAt(j);
            }
        }
        scan.close();
        int possiblePositions = calcPossiblePlaces(matrixExample, matrixDesert);
        System.out.println(possiblePositions);
    }
}
