import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[101][10];
        for(int i = 1; i < 10; i++)
            arr[1][i] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 10; j++) {
                if(j != 0)
                    arr[i][j] += arr[i-1][j-1];
                if(j != 9)
                    arr[i][j] += arr[i-1][j+1];
                arr[i][j] %= 1000000000;
            }
        }

        int result = 0;
        for(int i = 0; i < 10; i++)
            result = (result + arr[n][i]) % 1000000000;
        sb.append(result);
        System.out.println(sb);
    }
}