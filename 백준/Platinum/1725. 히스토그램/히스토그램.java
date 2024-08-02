import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            int num = arr[i];
            while(!stack.isEmpty() && arr[stack.peek()] > num) {
                int top = stack.pop();
                if(stack.isEmpty()) {
                    max = Math.max(max, arr[top] * i);
                } else
                    max = Math.max(max, arr[top] * (i-1 - stack.peek()));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int top = stack.pop();
            if(stack.isEmpty()) {
                max = Math.max(max, arr[top] * n);
            } else {
                max = Math.max(max, arr[top] * (n - (stack.peek() + 1)));
            }
            
        }

        sb.append(max);
        System.out.println(sb);
    }
}