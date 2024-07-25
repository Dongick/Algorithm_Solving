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
        List<int[]> list = new ArrayList<>();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = n-2; i >= 0; i--) {
            if(min >= price[i]) {
                min = price[i];
                sum += road[i];
            } else {
                list.add(new int[] {min, sum});
                min = price[i];
                sum = road[i];
            }
        }
        list.add(new int[] {min, sum});
        int result = 0;
        for(int[] arr : list) {
            result += arr[0] * arr[1];
        }
        sb.append(result);
        System.out.println(sb);
    }
}