import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static int[] trace;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int  k = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        for(int i = 0; i <= 100000; i++)
            arr[i] = 100001;
        trace = new int[100001];

        int time = dfs(n, k);
        sb.append(time).append("\n");

        int idx = k;
        int[] result = new int[time + 1];
        while(time >= 0) {
            result[time] = idx;
            idx = trace[idx];
            time--;
        }
        for(int num : result)
            sb.append(num).append(" ");
        System.out.println(sb);
    }

    static int dfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        boolean[] check = new boolean[100001];
        arr[n] = 0;

        while(!queue.isEmpty()) {
            int num = queue.poll();

            if(check[num])
                continue;
            check[num] = true;

            if(num - 1 >= 0 && arr[num-1] > arr[num] + 1) {
                arr[num-1] = arr[num] + 1;
                trace[num-1] = num;
                queue.offer(num-1);
            }
            if(num + 1 <= 100000 && arr[num+1] > arr[num] + 1) {
                arr[num+1] = arr[num] + 1;
                trace[num+1] = num;
                queue.offer(num+1);
            }
            if(num * 2 <= 100000 && arr[num*2] > arr[num] + 1) {
                arr[num*2] = arr[num] + 1;
                trace[num*2] = num;
                queue.offer(num*2);
            }
        }
        return arr[k];
    }
}