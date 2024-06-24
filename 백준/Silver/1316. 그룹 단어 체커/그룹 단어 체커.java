import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int result = 0;
        while(T-- > 0) {
            String s = br.readLine();
            boolean[] check = new boolean[26];
            if(check(s, check)) {
                result++;
            }
        }
        System.out.println(result);
    }
    
    static boolean check(String s, boolean[] check) {
        int prev = -1;
        for(int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 97;
            if(prev != num) {
                if(check[num] == false) {
                    check[num] = true;
                    prev = num;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}