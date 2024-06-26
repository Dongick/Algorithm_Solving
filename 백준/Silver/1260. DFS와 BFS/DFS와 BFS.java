import java.io.*;
import java.util.*;

class Main{
    static int[][] arr;
    static boolean[] check;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int first = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        check = new boolean[N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            arr[num1][num2] = arr[num2][num1] = 1;
        }
        dfs(first);
        sb.append("\n");
        check = new boolean[N+1];
        bfs(first);
        System.out.println(sb);
    }
    
    static void dfs(int node) {
        check[node] = true;
        sb.append(node + " ");
        for(int i = 1; i <= N; i++) {
            if(arr[node][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }
    
    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        check[node] = true;
        while(!queue.isEmpty()) {
            int num = queue.poll();
            sb.append(num + " ");
            for(int i = 1; i <= N; i++) {
                if(arr[num][i] == 1 && !check[i]) {
                    queue.offer(i);
                    check[i] = true;
                }
            }
        }
    }
}