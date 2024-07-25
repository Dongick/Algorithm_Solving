import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] road = new int[n-1];
        int[] price = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n-1; i++)
            road[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            price[i] = Integer.parseInt(st.nextToken());
        long sum = road[0];
        int min = price[0];
        long result = 0;
        for(int i = 1; i < n-1; i++) {
            if(min <= price[i]) {
                sum += road[i];
            } else {
                result += min * sum;
                min = price[i];
                sum = road[i];
            }
        }
        result += min * sum;
        sb.append(result);
        System.out.println(sb);
    }
}