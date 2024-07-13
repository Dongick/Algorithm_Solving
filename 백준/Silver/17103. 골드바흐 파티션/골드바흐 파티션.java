import java.util.*;
import java.io.*;

class Main {
    static boolean[] check = new boolean[1000001];
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Eratosthenes();
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 2; j <= arr[i]/2; j++) {
                if(!check[j] && !check[arr[i] - j])
                    count++;
            }
            sb.append(count).append("\n");
        }
        
        System.out.println(sb);
    }

    static void Eratosthenes() {
        check[1] = true;
        for(int i = 2; i <= Math.sqrt(1000000); i++) {
            if(check[i])
                continue;
            for(int j = i * i; j <= 1000000; j += i) {
                if(!check[j])
                    check[j] = true;
            }
        }
    }
}