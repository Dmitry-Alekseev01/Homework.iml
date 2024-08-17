import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GameLife {
    public static int countAlive(char[][] matrix, int row, int col) {
        int count = 0;
        for (int i = row - 1; i < row + 2; i++) {
            for (int j = col - 1; j < col + 2; j++) {
                int resRow = i;
                int resColumn = j;
                if (i == row && j == col) {
                    continue;
                }
                if(resRow < 0){
                    resRow = matrix.length - 1;
                }
                if(resRow == matrix.length){
                    resRow = 0;
                }
                if(resColumn < 0){
                    resColumn = matrix[0].length - 1;
                }
                if(resColumn == matrix[0].length){
                    resColumn = 0;
                }
                if (matrix[resRow][resColumn] == '*') {
                    count++;
                }

            }
        }
        return count;
    }

    public static void game(char[][] matrix, int k) {
        char[][] resMatrix = new char[matrix.length][matrix[0].length];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int l = 0; l < matrix[0].length; l++) {
                    int count = countAlive(matrix, j, l);
                    if (matrix[j][l] == '*') {
                        if (count < 2 || count > 3) {
                            resMatrix[j][l] = '.';
                        } else {
                            resMatrix[j][l] = '*';
                        }
                    } else {
                        if (count == 3) {
                            resMatrix[j][l] = '*';
                        } else {
                            resMatrix[j][l] = '.';
                        }
                    }
                }
            }
            matrix = Arrays.copyOf(resMatrix, resMatrix.length);
            printMatrix(matrix);
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("input.txt"));
        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = scan.next();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = s.charAt(j);
            }
        }
        scan.close();
        printMatrix(matrix);
        game(matrix, k);
    }
}
