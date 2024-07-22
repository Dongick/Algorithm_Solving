import java.util.*;
import java.io.*;

class Main {
    static int[][] dp;
    static char[] arr1;
    static char[] arr2;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
        
        dp = new int[arr1.length][arr2.length];
        if(arr1[0] == arr2[0])
            dp[0][0] = 1;
        
        for(int i = 1; i < arr2.length; i++) {
            if(dp[0][i-1] == 1)
                dp[0][i] = 1;
            else if(arr1[0] == arr2[i] && dp[0][i-1] == 0) {
                dp[0][i] = 1;
            }
        }
        
        for(int i = 1; i < arr1.length; i++) {
            if(dp[i-1][0] == 1)
                dp[i][0] = 1;
            if(arr1[i] == arr2[0] && dp[i-1][0] == 0)
                dp[i][0] = 1;
        }
        
        for(int i = 1; i < arr1.length; i++) {
            for(int j = 1; j < arr2.length; j++) {
                if(arr1[i] == arr2[j])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
            
        sb.append(dp[arr1.length-1][arr2.length-1]);
        System.out.println(sb);
    }
}