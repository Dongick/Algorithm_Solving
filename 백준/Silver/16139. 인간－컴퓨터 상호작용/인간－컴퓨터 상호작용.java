import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        for(int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            char[] arr = s.substring(l, r+1).toCharArray();
            int count = 0;
            for(char c : arr) {
                if(c == a)
                    count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}