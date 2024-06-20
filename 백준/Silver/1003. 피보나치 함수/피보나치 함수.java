import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[][] arr = new int[num + 1][2];
            if(num == 0) {
                System.out.println("1 0");
            } else if(num == 1) {
                System.out.println("0 1");
            } else {
                arr[0][0] = 1;
                arr[0][1] = 0;
                arr[1][0] = 0;
                arr[1][1] = 1;
                fibo(num, arr);
                System.out.println(arr[num][0] + " " + arr[num][1]);
            }
        }
    }
    
    static void fibo(int num, int[][] arr) {
        for(int i = 2; i <= num; i++) {
            arr[i][0] = arr[i-1][0] + arr[i-2][0];
            arr[i][1] = arr[i-1][1] + arr[i-2][1];
        }
    }
}