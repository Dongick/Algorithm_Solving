import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        while(T-- > 0) {
            String[] s = br.readLine().split(" ");
            if(s[0].equals("push")) {
                stack.push(Integer.parseInt(s[1]));
            } else {
                switch(s[0]) {
                    case "top":
                        if(!stack.isEmpty()) {
                            sb.append(stack.peek()).append("\n");
                            break;
                        } else {
                            sb.append(-1).append("\n");
                            break;
                        }
                    case "size":
                        sb.append(stack.size()).append("\n");
                        break;
                    case "empty":
                        if(stack.isEmpty()) {
                            sb.append(1).append("\n");
                            break;
                        } else {
                            sb.append(0).append("\n");
                            break;
                        }
                    case "pop":
                        if(stack.isEmpty()) {
                            sb.append(-1).append("\n");
                            break;
                        } else {
                            sb.append(stack.pop()).append("\n");
                            break;
                        }
                }
            }
        }
        System.out.println(sb);
    }
}