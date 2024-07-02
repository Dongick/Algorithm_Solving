import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            LinkedList<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                queue.offer(new int[] {i, Integer.parseInt(st.nextToken())});
            }
            int count = 0;
            while(!queue.isEmpty()) {
                boolean check = false;
                int[] num = queue.poll();
                
                for(int i = 0; i < queue.size(); i++) {
                    if(num[1] < queue.get(i)[1]) {
                        queue.offer(num);
                        check = true;
                        for(int j = 0; j < i; j++) {
                            queue.offer(queue.poll());
                        }
                        break;
                    }
                }
                if(!check) {
                    count++;
                    if(num[0] == m) {
                        sb.append(count).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}