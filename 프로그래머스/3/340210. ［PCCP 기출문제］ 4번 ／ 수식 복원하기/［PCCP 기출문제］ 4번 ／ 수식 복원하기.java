import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        int binary = 2;
        int resultBinary = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < expressions.length; i++) {
            String[] arr = expressions[i].split(" ");
            int n1 = Integer.parseInt(arr[0]);
            int n2 = Integer.parseInt(arr[2]);
            char operation = arr[1].charAt(0);
            
            binary = Math.max(binary, Math.max(n1 % 10 + 1, Math.max(n1 / 10 + 1, Math.max(n2 % 10 + 1, n2 / 10 + 1))));
            
            if(arr[4].equals("X")) {
                list.add(i);
                continue;
            }
            
            if(resultBinary != 0)
                continue;
            
            int result = Integer.parseInt(arr[4]);
            binary = Math.max(binary, Math.max(result % 10 + 1, Math.max((result / 10) % 10 + 1, result / 100 + 1)));
            
            List<Integer> check = new ArrayList<>();
            for(int j = binary; j <= 9; j++) {
                int num1 = func(n1, j);
                int num2 = func(n2 ,j);
                int num3 = func(result, j);
                
                if(operation == '+') {
                    if(num1 + num2 == num3)
                        check.add(j);
                } else {
                    if(num1 - num2 == num3)
                        check.add(j);
                }
            }
            
            if(check.size() == 1)
                resultBinary = check.get(0);
            
            binary = check.get(0);
        }
        
        String[] answer = new String[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            String[] arr = expressions[list.get(i)].split(" ");
            answer[i] = arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " ";
            int n1 = Integer.parseInt(arr[0]);
            int n2 = Integer.parseInt(arr[2]);
            char operation = arr[1].charAt(0);
            
            if(resultBinary != 0) {
                int num1 = func(n1, resultBinary);
                int num2 = func(n2, resultBinary);
                int num;
                
                if(operation == '+') {
                    num = func2(num1 + num2, resultBinary);
                } else {
                    num = func2(num1 - num2, resultBinary);
                }
                answer[i] += num;
            } else {
                HashSet<Integer> set = new HashSet<>();
                for(int j = binary; j <= 9; j++) {
                    int num1 = func(n1, j);
                    int num2 = func(n2, j);
                    int num;
                    
                    if(operation == '+') {
                        num = func2(num1 + num2, j);
                    } else {
                        num = func2(num1 - num2, j);
                    }
                    
                    set.add(num);
                }
                
                if(set.size() != 1)
                    answer[i] += "?";
                else {
                    Iterator<Integer> iter = set.iterator();
                    answer[i] += iter.next();
                }
            }
        }
        return answer;
    }
    
    static int func(int num, int binary) {
        int idx = 0;
        int result = 0;
        while(num > 0) {
            result += Math.pow(binary, idx) * (num % 10);
            num /= 10;
            idx++;
        }
        
        return result;
    }
    
    static int func2(int num, int binary) {
        String s = "";
        Stack<Integer> stack = new Stack<>();
        while(num >= binary) {
            stack.push(num % binary);
            num /= binary;
        }
        stack.push(num);
        
        while(!stack.empty()) {
            s += stack.pop();
        }
        
        return Integer.parseInt(s);
    }
}