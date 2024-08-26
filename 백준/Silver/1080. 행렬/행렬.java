import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static int[][] arr2;
    static int n, m;
    static int count = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++)
                arr[i][j] = s.charAt(j) - '0';
        }

        arr2 = new int[n][m];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++)
                arr2[i][j] = s.charAt(j) - '0';
        }

        func();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] != arr2[i][j]) {
                    sb.append(-1);
                    System.out.println(sb);
                    return;
                }
            }
        }
        sb.append(count);
        
        System.out.println(sb);
    }

    static void func() {
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j <= m - 3; j++) {
                if(arr[i][j] != arr2[i][j]) {
                    count++;
                    for(int x = 0; x < 3; x++) {
                        for(int y = 0; y < 3; y++) {
                            if(arr[i+x][j+y] == 0)
                                arr[i+x][j+y] = 1;
                            else
                                arr[i+x][j+y] = 0;
                        }
                    }
                }
            }
        }
    }
}