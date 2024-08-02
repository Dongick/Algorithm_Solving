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
        
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {arr[0], 1});
        long result = 0;
        for(int i = 1; i < n; i++) {
            int num = arr[i];
            while(!stack.isEmpty() && stack.peek()[0] < num) {
                result += stack.pop()[1];
            }

            if(stack.isEmpty())
                stack.push(new int[] {num, 1});
            else {
                if(stack.peek()[0] > num) {
                    stack.push(new int[] {num, 1});
                    result++;
                } else {
                    result += stack.peek()[1]++;
                    if(stack.size() > 1)
                        result++;
                }
            }
        }

        sb.append(result);
        System.out.println(sb);
    }
}