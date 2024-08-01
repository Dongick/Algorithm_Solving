import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        String boom = br.readLine();
        int size = boom.length();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            if(stack.size() >= size) {
                boolean check = true;
                for(int j = 0; j < size; j++) {
                    if(stack.get(stack.size() - size + j) != boom.charAt(j)) {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    for(int j = 0; j < size; j++)
                        stack.pop();
                }
            }
        }

        if(stack.isEmpty())
            sb.append("FRULA");
        else {
            for(Character c : stack) {
    			sb.append(c);
    		}
        }
            
        System.out.println(sb);
    }
}