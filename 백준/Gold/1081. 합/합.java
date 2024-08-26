import java.util.*;
import java.io.*;

class Main {
    static long[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        arr = new long[10];
        for(int i = 1; i < 10; i++) {
            arr[i] = arr[i-1] * 10 + 45 * (long)Math.pow(10, i-1);
        }

        long result = func(U) - func(L-1);
        sb.append(result);
        System.out.println(sb);
    }

    static long func(int number) {
        long sum = 0;
        int num = number;
        int digit = 0;
        while(num >= 10) {
            num /= 10;
            digit++;
        }

        num = number;
        while(num > 0) {
            int temp = num / (int)Math.pow(10, digit);
            sum += temp * arr[digit];
            for(int i = 1; i < temp; i++)
                sum += (long)Math.pow(10, digit) * i;
            num = num % (int)Math.pow(10, digit);
            sum += temp * (num+1);
            digit--;
        }

        return sum;
    }
}