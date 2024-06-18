import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            List<List<Integer>> list = new ArrayList<>();
            int[] d = new int[num + 1];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= num; i++) {
                list.add(new ArrayList<>());
                d[i] = Integer.parseInt(st.nextToken());
            }
            list.add(new ArrayList<>());
            
            int[] indegree = new int[num + 1];
            for(int i = 0; i < count; i++) {
                st = new StringTokenizer(br.readLine());
                int s1 = Integer.parseInt(st.nextToken());
                int s2 = Integer.parseInt(st.nextToken());
                list.get(s1).add(s2);
                indegree[s2]++;
            }
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            
            TopologySort(list, d, indegree, w, num);
        }
    }
    
    static void TopologySort(List<List<Integer>> list, int[] d, int[] indegree, int w, int num) {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[num + 1];
        for(int i = 1; i <= num; i++) {
            result[i] = d[i];
            
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()) {
            int node = q.poll();
            
            for(int i : list.get(node)) {
                result[i] = Math.max(result[i], result[node] + d[i]);
                indegree[i]--;
                
                if(indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }
        System.out.println(result[w]);
    }
}