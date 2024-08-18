import java.util.*;
import java.io.*;

class Main {
    static List<List<Integer>> list;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int Case = 0;
        
        while(true) {
            Case++;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0)
                break;
            list = new ArrayList<>();
            for(int i = 0; i <= n; i++)
                list.add(new ArrayList<>());
            
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }
            visited = new boolean[n+1];
            count = 0;

            for(int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    if(bfs(i)) {
                        count++;
                    }
                }
            }
            if(count == 0) {
                sb.append("Case " + Case + ": No trees.").append("\n");
            } else if (count == 1) {
                sb.append("Case " + Case + ": There is one tree.").append("\n");
            } else {
                sb.append("Case " + Case + ": A forest of " + count + " trees.").append("\n");
            }
        }
        
        System.out.println(sb);
    }

    static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean check = false;
        while(!queue.isEmpty()) {
            int num = queue.poll();
            if(visited[num])
                check = true;
            visited[num] = true;

            for(int next : list.get(num)) {
                if(!visited[next]) {
                    queue.offer(next);
                }
            }
        }
        if(!check)
            return true;
        else
            return false;
    }
}