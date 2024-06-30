import java.io.*;
import java.util.*;

class Main{
    static List<Integer>[] list;
    static int[] arr;
    static boolean[] check;
    
    static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        check[num] = true;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : list[cur]) {
                if(!check[next]) {
                    queue.offer(next);
                    check[next] = true;
                    arr[next] = cur;
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        arr = new int[N + 1];
        check = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            
            list[num1].add(num2);
            list[num2].add(num1);
        }
        
        bfs(1);
        for(int i = 2; i <= N; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}