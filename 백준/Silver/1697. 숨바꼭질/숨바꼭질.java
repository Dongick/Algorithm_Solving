import java.util.*;
import java.io.*;

class Main {
    static int[] check;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        check = new int[200001];
        sb.append(bfs(n, k) - 1);
        System.out.println(sb);
    }

    static int bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        check[n] = 1;
        while(!queue.isEmpty() && check[k] == 0) {
            int num = queue.poll();
            if((num - 1) >= 0 && check[num-1] == 0) {
                queue.offer(num-1);
                check[num-1] = check[num] + 1;
            }
            if((num + 1) <= 200000 && check[num+1] == 0) {
                queue.offer(num+1);
                check[num+1] = check[num] + 1;
            }
            if((num * 2) <= 200000 && check[num*2] == 0) {
                queue.offer(num*2);
                check[num*2] = check[num] + 1;
            }
        }
        return check[k];
    }
}