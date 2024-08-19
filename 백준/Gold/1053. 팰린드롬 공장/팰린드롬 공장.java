import java.util.*;
import java.io.*;

class Main {
    static int[][] dp;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        char[] c = new char[s.length()];
        for(int i = 0; i < s.length(); i++)
            c[i] = s.charAt(i);
        int result = palindrome(c);

        for(int i = 0; i < s.length() - 1; i++) {
            for(int j = i+1; j < s.length(); j++) {
                swap(c, i, j);
                result = Math.min(result, palindrome(c) + 1);
                swap(c, i, j);
            }
        }
        sb.append(result);
        
        System.out.println(sb);
    }

    static int palindrome(char[] arr) {
        dp = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] != arr[i+1])
                dp[i][i+1] = 1;
        }

        for(int i = 2; i < arr.length; i++) {
            for(int j = 0; i + j < arr.length; j++) {
                dp[j][i+j] = Math.min(dp[j][i+j-1] + 1, dp[j+1][i+j] + 1);

                if(arr[j] == arr[j+i])
                    dp[j][i+j] = Math.min(dp[j][i+j], dp[j+1][i+j-1]);
                else
                    dp[j][i+j] = Math.min(dp[j][i+j], dp[j+1][i+j-1] + 1);
            }
        }

        return dp[0][arr.length-1];
    }

    static void swap(char[] arr, int idx1, int idx2) {
        char temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}