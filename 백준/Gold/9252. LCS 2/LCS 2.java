import java.util.*;
import java.io.*;

class Main {
    static char[] seq1, seq2;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        seq1 = new char[s.length()+1];
        for(int i = 1; i <= s.length(); i++)
            seq1[i] = s.charAt(i-1);
        s = br.readLine();
        seq2 = new char[s.length()+1];
        for(int i = 1; i <= s.length(); i++)
            seq2[i] = s.charAt(i-1);

        int[][] arr = new int[seq1.length][seq2.length];
        for(int i = 1; i < seq1.length; i++) {
            for(int j = 1; j < seq2.length; j++) {
                if(seq1[i] == seq2[j]) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        }
        int size = arr[seq1.length-1][seq2.length-1];
        if(size == 0) {
            sb.append(0);
            System.out.println(sb);
            return;
        }
        sb.append(size).append("\n");
        int i = seq1.length - 1;
        int j = seq2.length - 1;
        char[] result = new char[size];
        while(size > 0) {
            if(seq1[i] == seq2[j]) {
                size--;
                result[size] = seq1[i];
                i--;
                j--;
            } else {
                if(arr[i][j-1] > arr[i-1][j])
                    j--;
                else
                    i--;
            }
        }
        for(char alpa : result)
            sb.append(alpa);
        System.out.println(sb);
    }
}