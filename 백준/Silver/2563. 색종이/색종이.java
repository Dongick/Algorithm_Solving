import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[101][101];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j = y; j < y + 10; j++) {
                for(int k = x; k < x + 10; k++)
                    arr[j][k] = true;
            }
        }
        int count = 0;
        for(int i = 1; i <= 100; i++) {
            for(int j = 1; j <= 100; j++)
                if(arr[i][j])
                    count++;
        }
        System.out.println(count);
    }
}