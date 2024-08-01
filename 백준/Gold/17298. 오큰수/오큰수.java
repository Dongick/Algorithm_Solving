import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        for(int i = n-1; i >= 0; i--) {
            int num = arr[i];

            while(!stack.isEmpty() && stack.peek() <= num)
                stack.pop();

            if(stack.isEmpty())
                result[i] = -1;
            else
                result[i] = stack.peek();

            stack.push(num);
        }
        

        for(int i = 0; i < n; i++)
            sb.append(result[i]).append(" ");
            
        System.out.println(sb);
    }
}