import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        while(n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if(num != 0)
                stack.add(num);
            else
                stack.pop();
        }
        int sum = 0;
        for(int num : stack)
            sum += num;
        sb.append(sum);
        System.out.println(sb);
    }
}