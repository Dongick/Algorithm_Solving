import java.io.*;
import java.util.*;

class Main{
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] check;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n][m];
            check = new boolean[n][m];
            int result = 0;
            
            int num = Integer.parseInt(st.nextToken());
            for(int i = 0; i < num; i++) {
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(arr[i][j] == 1 && check[i][j] == false) {
                        DFS(i, j);
                        result ++;
                    }
                }
            }
            System.out.println(result);
        }
    }
    
    static void DFS(int x, int y) {
        check[x][y] = true;
        int[] xarr = {1, -1, 0, 0};
        int[] yarr = {0, 0, 1, -1};
        for(int i = 0; i < 4; i++) {
            int cx = x + xarr[i];
            int cy = y + yarr[i];
            
            if(cx >= 0 && cy >= 0 && cx < n && cy < m) {
                if(arr[cx][cy] == 1 && check[cx][cy] == false) {
                    DFS(cx, cy);
                }
            }
        }
    }
}