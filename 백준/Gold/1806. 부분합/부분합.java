import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int result = n+1;
        int front = 0;
        int back = 0;
        int sum = arr[0];
        while(front != n) {
            if(sum >= s) {
                result = Math.min(result, back - front + 1);
                if(back == front) {
                    if(back == n-1)
                        break;
                    sum -= arr[front];
                    front++;
                    back++;
                    sum += arr[back];
                } else {
                    sum -= arr[front];
                    front++;
                }
            } else {
                if(back < n-1) {
                    back++;
                    sum += arr[back];
                } else
                    break;
            }
        }
        if(result == n+1)
            sb.append(0);
        else
            sb.append(result);

        System.out.println(sb);
    }
}