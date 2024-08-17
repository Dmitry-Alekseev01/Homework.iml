import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Tablet {
    public static boolean showTablet(char[][] matrixColors, int[][]matrixCodes){
        HashMap<Integer, ArrayList<Character>> map = new HashMap<>();
        map.put(0, new ArrayList<>(List.of('.')));
        map.put(1, new ArrayList<>(List.of('.', 'B')));
        map.put(2, new ArrayList<>(List.of('.', 'G')));
        map.put(3, new ArrayList<>(List.of('.', 'G', 'B')));
        map.put(4, new ArrayList<>(List.of('.', 'R')));
        map.put(5, new ArrayList<>(List.of('.', 'R', 'B')));
        map.put(6, new ArrayList<>(List.of('.', 'R', 'G')));
        map.put(7, new ArrayList<>(List.of('.', 'R', 'G', 'B')));
        for(int i = 0; i < matrixColors.length; i++){
            for(int j = 0; j < matrixColors[0].length; j++){
                int code = matrixCodes[i][j];
                ArrayList<Character> list = map.get(code);
                if(!list.contains(matrixColors[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("input1.txt"));
        int n = scan.nextInt();
        int m = scan.nextInt();
        char[][] matrixColors = new char[n][m];
        int[][] matrixCodes = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = scan.next();
            for (int j = 0; j < m; j++) {
                matrixColors[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixCodes[i][j] = scan.nextInt();
            }
        }
        scan.close();
        if(showTablet(matrixColors, matrixCodes)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
