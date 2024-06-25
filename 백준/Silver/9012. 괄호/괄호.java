import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            char[] arr = br.readLine().toCharArray();
            int leftCount = 0;
            int rightCount = 0;
            boolean error = false;
            for(char parenthesis : arr) {
                if(parenthesis == '(') {
                    leftCount++;
                } else {
                    rightCount++;
                }
                if(rightCount > leftCount) {
                    error = true;
                }
            }
            if(leftCount == rightCount && error == false) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}