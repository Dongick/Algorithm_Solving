import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int result = 0;
        while(a != b) {
            a = (a % 2 == 0) ? a / 2 : a / 2 + 1;
            b = (b % 2 == 0) ? b / 2 : b / 2 + 1;
            result++;
        }
        sb.append(result);
        System.out.println(sb);
        
    }
}