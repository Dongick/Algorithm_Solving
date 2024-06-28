import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n <= 99) {
            System.out.println(n);
        } else {
            int result = 99;
            int n1, n2, n3, temp;
            for(int i = 111; i <= n; i++) {
                temp = i;
                n1 = temp / 100;
                temp %= 100;
                n2 = temp / 10;
                n3 = temp % 10;
                if(n1 + n3 == n2 * 2)
                    result++;
            }
            System.out.println(result);
        }
    }
}