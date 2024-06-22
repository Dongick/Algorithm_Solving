import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean[] check = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        int[] address = new int[n];
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(arr[i] > arr[j]) {
                    count++;
                }
            }
            while(check[count]) {
                count++;
            }
            address[i] = count;
            check[count] = true;
        }
        for(int i = 0; i < n; i++) {
            System.out.print(address[i] + " ");
        }
    }
}