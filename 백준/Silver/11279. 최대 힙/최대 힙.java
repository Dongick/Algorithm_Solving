import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        while(n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(queue.isEmpty())
                    sb.append(0).append("\n");
                else
                    sb.append(queue.poll()).append("\n");
            } else {
                queue.offer(num);
            }
        }
        System.out.println(sb);
    }
}