import java.io.*;
import java.util.*;

class Main{
    static int m;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++)
                arr[i][j] = s.charAt(j) - '0';
        }
        int k = Integer.parseInt(br.readLine());
        int result = 0;
        
        for(int i = 0; i < n; i++) {
            int zeroCount = 0;
            int count = 0;
            for(int j = 0; j < m; j++)
                if(arr[i][j] == 0)
                    zeroCount++;
            if(k % 2 == zeroCount % 2 && zeroCount <= k) {
                for(int j = 0; j < n; j++) {
                    if(same(arr[i], arr[j]))
                        count++;
                }
            }
            result = Math.max(count, result);
        }
        System.out.println(result);
    }
    
    static boolean same(int[] arr, int[] arr2) {
        for(int i = 0; i < m; i++) {
            if(arr[i] != arr2[i])
                return false;
        }
        return true;
    }
}