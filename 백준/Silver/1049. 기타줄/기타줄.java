import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int min6 = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            min6 = Math.min(min6, Integer.parseInt(st.nextToken()));
            min1 = Math.min(min1, Integer.parseInt(st.nextToken()));
        }

        if(min1 * 6 < min6) {
            sb.append(min1 * n);
        } else {
            int result = 0;
            while(n >= 6) {
                result += min6;
                n -= 6;
            }
            if(min1 * n > min6)
                result += min6;
            else
                result += min1 * n;
            sb.append(result);
        }
        
        System.out.println(sb);
    }
}