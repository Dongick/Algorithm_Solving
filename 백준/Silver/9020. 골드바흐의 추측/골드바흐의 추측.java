import java.io.*;
import java.util.*;

class Main{
    static boolean[] arr = new boolean[10001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        function();
        while(T-- > 0) {
            boolean check = false;
            int n = Integer.parseInt(br.readLine());
            int num1 = n/2;
            int num2 = n/2;
            while(true) {
                if(arr[num1] || arr[num2]) {
                    num1--;
                    num2++;
                } else {
                    sb.append(num1).append(" ").append(num2).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
    
    static void function() {
        arr[0] = arr[1] = true;
        for(int i = 2; i <= Math.sqrt(10000); i++) {
            if(arr[i])
                continue;
            for(int j = i*i; j <= 10000; j += i) {
                if(!arr[j])
                    arr[j] = true;
            }
        }
    }
}