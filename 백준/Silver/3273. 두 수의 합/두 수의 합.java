import java.util.*;
import java.io.*;

class Main {
    final static int INF = 400 * 10000 + 1;
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int result = 0;
        int front = 0;
        int back = n-1;
        while(front < back) {
            int temp = arr[front] + arr[back];
            if(temp == x) {
                result++;
                front++;
                back--;
            }
            if(temp > x)
                back--;
            if(temp < x)
                front++;
            
        }

        sb.append(result);
        System.out.println(sb);
    }
}