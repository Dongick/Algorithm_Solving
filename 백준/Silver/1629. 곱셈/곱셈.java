import java.util.*;
import java.io.*;

class Main {
    static int c;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        sb.append(pow(a, b));
        System.out.println(sb);
    }

    static int pow(int num, int count) {
        if(count == 1)
            return num % c;

        long temp = pow(num, count / 2);
        if(count % 2 == 1)
            return (int)((temp * temp % c) * num % c);
        return (int)(temp * temp % c);
    }
}