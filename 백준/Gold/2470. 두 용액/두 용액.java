import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];
        int front = 0;
        int back = n-1;
        while(front < back) {
            int temp = arr[front] + arr[back];
            if(Math.abs(min) > Math.abs(temp)) {
                min = temp;
                result[0] = arr[front];
                result[1] = arr[back];
            }
            if(temp > 0)
                back--;
            if(temp < 0)
                front++;
            if(temp == 0)
                break;
            
        }

        sb.append(result[0]).append(" ").append(result[1]);
        System.out.println(sb);
    }
}