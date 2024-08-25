import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());

        int num = n - n % 100;
        num = num % f;
        if(num == 0)
            sb.append("00");
        else {
            num = f - num;
            if(num >= 10)
                sb.append(num);
            else
                sb.append(0).append(num);
        }
        System.out.println(sb);
    }
}