import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        if(a1 * n + a0 <= c * n) {
            if(a1 == c && a0 <= 0)
                System.out.println(1);
            else if(a1 < c)
                System.out.println(1);
            else
                System.out.println(0);
        } else
            System.out.println(0);
    }
}