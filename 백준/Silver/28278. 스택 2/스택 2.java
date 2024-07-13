import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num == 1)
                stack.add(Integer.parseInt(st.nextToken()));
            else if(num == 2) {
                if(!stack.isEmpty())
                    sb.append(stack.pop()).append("\n");
                else
                    sb.append(-1).append("\n");
            } else if(num == 3)
                sb.append(stack.size()).append("\n");
            else if(num == 4) {
                if(stack.isEmpty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            } else {
                if(!stack.isEmpty())
                    sb.append(stack.peek()).append("\n");
                else
                    sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }
}