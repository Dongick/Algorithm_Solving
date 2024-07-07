import java.util.*;
import java.io.*;

class Main {
    static int max = 0;
    static int k, size;
    static boolean[][] check = new boolean[11][1000001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int num = Integer.parseInt(s);
        k = Integer.parseInt(st.nextToken());
        size = s.length();
        if(num < 10) {
            System.out.println(-1);
            return;
        }
        
        dp(0, num);
        
        if(max == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(max);
    }

    static void dp(int count, int num) {
        if(check[count][num])
            return;
        check[count][num] = true;
        if(count == k) {
            max = Math.max(num, max);
            return;
        }
        String tempS = Integer.toString(num);
        for(int i = 0; i < size - 1; i++) {
            int maxNum = 0;
            
            for(int j = i + 1; j < size; j++) {
                maxNum = Math.max(maxNum, tempS.charAt(j) - '0');
            }
            for(int j = i + 1; j < size; j++) {
                int tempNum = 0;
                if(i == 0 && tempS.charAt(j) - '0' == 0)
                    continue;
                if(tempS.charAt(j) - '0' == maxNum) {
                    for(int w = 0; w < size; w++) {
                        if(w == i)
                            tempNum = tempNum * 10 + tempS.charAt(j) - '0';
                        else if(w == j)
                            tempNum = tempNum * 10 + tempS.charAt(i) - '0';
                        else
                            tempNum = tempNum * 10 + tempS.charAt(w) - '0';
                    }
                    dp(count+1, tempNum);
                }
            }
        }
    }
}