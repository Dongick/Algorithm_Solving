import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            deque.offer(new int[] {i, num});
        }
        int[] num = deque.poll();
        sb.append(num[0]).append(" ");
        while(!deque.isEmpty()) {
            if(num[1] > 0) {
                for(int i = 1; i < num[1]; i++) {
                    deque.offer(deque.poll());
                }
                num = deque.poll();
                sb.append(num[0]).append(" ");
            } else {
                for(int i = 1; i < Math.abs(num[1]); i++) {
                    deque.offerFirst(deque.pollLast());
                }
                num = deque.pollLast();
                sb.append(num[0]).append(" ");
            }
        }
        System.out.println(sb);
    }
}