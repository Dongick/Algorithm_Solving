import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] c = br.readLine().toCharArray();
        int[][] arr = new int[26][c.length + 1];
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < c.length; j++) {
                if(c[j] - 'a' == i) {
                    arr[i][j+1] = arr[i][j] + 1;
                } else
                    arr[i][j+1] = arr[i][j];
            }
        }
        int q = Integer.parseInt(br.readLine());
        for(int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(arr[a - 'a'][r+1] - arr[a - 'a'][l]).append("\n");
        }
        System.out.println(sb);
    }
}