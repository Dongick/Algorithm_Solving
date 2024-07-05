import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++)
                arr[i][j] = s.charAt(j);
        }
        int result = 0;
        for(int i = 0; i < n; i++) {
            int count = 0;
            boolean[] check = new boolean[n];
            check[i] = true;
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 'Y') {
                    if(!check[j]) {
                        check[j] = true;
                        count++;
                    }
                    for(int k = 0; k < n; k++) {
                        if(arr[j][k] == 'Y' && !check[k]) {
                            check[k] = true;
                            count++;
                        }
                    }
                }
            }
            result = Math.max(count, result);
        }
        System.out.println(result);
    }
}