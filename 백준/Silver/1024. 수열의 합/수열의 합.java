import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        
        boolean check = false;
        for(int i = l; i <= 100; i++) {
            int quotient = n / i;
            int remain = n % i;

            if(i % 2 == 1) {
                if(remain == 0) {
                    quotient -= i / 2;
                    if(quotient < 0)
                        break;
                    for(int j = 0; j < i; j++) {
                        sb.append(quotient).append(" ");
                        quotient++;
                    }
                    check = true;
                    break;
                }
            } else {
                if(remain * 2 == i) {
                    quotient -= (i / 2 - 1);
                    if(quotient < 0)
                        break;
                    for(int j = 0; j < i; j++) {
                        sb.append(quotient).append(" ");
                        quotient++;
                    }
                    check = true;
                    break;
                }
            }
        }
        if(!check)
            sb.append(-1);
        System.out.println(sb);
    }
}