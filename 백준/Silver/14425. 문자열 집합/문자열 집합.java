import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) 
            arr[i] = br.readLine();
        int count = 0;
        for(int i = 0; i < m; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                if(arr[j].equals(s)) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}