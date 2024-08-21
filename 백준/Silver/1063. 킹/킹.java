import java.util.*;
import java.io.*;

class Main {
    static char[] king;
    static char[] stone;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        king = new char[2];
        stone = new char[2];
        king[0] = s.charAt(0);
        king[1] = s.charAt(1);
        s = st.nextToken();
        stone[0] = s.charAt(0);
        stone[1] = s.charAt(1);
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            s = br.readLine();
            func(s);
        }
        sb.append(king[0]).append(king[1]).append("\n");
        sb.append(stone[0]).append(stone[1]).append("\n");
        System.out.println(sb);
    }

    static void func(String s) {
        char kingCol = king[0];
        char kingRow = king[1];
        char stoneCol = stone[0];
        char stoneRow = stone[1];
        switch (s) {
            case "R":
                kingCol++;
                if(kingCol == stoneCol && kingRow == stoneRow)
                    stoneCol++;
                break;
            case "L":
                kingCol--;
                if(kingCol == stoneCol && kingRow == stoneRow)
                    stoneCol--;
                break;
            case "B":
                kingRow--;
                if(kingCol == stoneCol && kingRow == stoneRow)
                    stoneRow--;
                break;
            case "T":
                kingRow++;
                if(kingCol == stoneCol && kingRow == stoneRow)
                    stoneRow++;
                break;
            case "RT":
                kingCol++;
                kingRow++;
                if(kingCol == stoneCol && kingRow == stoneRow) {
                    stoneCol++;
                    stoneRow++;
                }
                break;
            case "LT":
                kingCol--;
                kingRow++;
                if(kingCol == stoneCol && kingRow == stoneRow) {
                    stoneCol--;
                    stoneRow++;
                }
                break;
            case "RB":
                kingCol++;
                kingRow--;
                if(kingCol == stoneCol && kingRow == stoneRow) {
                    stoneCol++;
                    stoneRow--;
                }
                break;
            case "LB":
                kingCol--;
                kingRow--;
                if(kingCol == stoneCol && kingRow == stoneRow) {
                    stoneCol--;
                    stoneRow--;
                }
                break;
        }
        
        if(kingCol < 'A' || kingCol > 'H' || stoneCol < 'A' || stoneCol > 'H' || kingRow < '1' || kingRow > '8' || stoneRow < '1' || stoneRow > '8')
            return;
        king[0] = kingCol;
        king[1] = kingRow;
        stone[0] = stoneCol;
        stone[1] = stoneRow;
    }

}