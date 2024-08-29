import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int x = Integer.parseInt(br.readLine());
        int result = 1;
        int sum = 64;
        Stack<Integer> stack = new Stack<>();
        stack.push(sum);
        while(x != sum) {
            int num = stack.pop();
            if(sum - num / 2 >= x) {    
                sum -= num / 2;
            } else {
                stack.push(num / 2);
                result++;
            }
            stack.push(num / 2);
        }
        sb.append(result);
        System.out.println(sb);
    }
}