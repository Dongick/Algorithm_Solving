import java.util.*;
import java.io.*;

class Main {
    static boolean[] num;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        num = new boolean[n+1];
        eratosthenes(n);

        int front = 2;
        int back = 2;
        int sum = 2;
        int result = 0;
        boolean check = true;
        while(front < n || back < n) {
            if(sum == n) {
                result++;
                sum -= front;
                for(int i = front+1; i <= n; i++) {
                    if(!num[i]) {
                        front = i;
                        break;
                    }
                    if(i == n)
                        check = false;
                }
            } else if(sum > n) {
                while(sum > n) {
                    sum -= front;
                    for(int i = front+1; i <= n; i++) {
                        if(!num[i]) {
                            front = i;
                            break;
                        }
                        if(i == n)
                            check = false;
                    }
                }
            } else {
                while(sum < n) {
                    for(int i = back+1; i <= n; i++) {
                        if(!num[i]) {
                            back = i;
                            break;
                        }
                        if(i == n)
                            check = false;
                    }
                    sum += back;
                }
            }
            if(!check)
                break;
        }
        if(front == n && back == n) {
            if(sum == n)
                result++;
        }
        sb.append(result);
        System.out.println(sb);
    }

    static void eratosthenes(int n) {
        num[1] = true;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(num[i])
                continue;

            for(int j = i*i; j <= n; j = i+j)
                num[j] = true;
        }
    }
}