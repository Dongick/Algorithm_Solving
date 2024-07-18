import java.util.*;
import java.io.*;

class Main {
    static boolean[][] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new boolean[n][n];
        star(0, 0, n);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j])
                    sb.append("*");
                else
                    sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void star(int x, int y, int size) {
        if(size == 1) {
            arr[x][y] = true;
            return;
        }
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(!(i == 1 && j == 1)) {
                    star(x + i * size / 3, y + j * size / 3, size / 3);
                }
            }
        }
    }
}