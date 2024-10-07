import java.util.*;

class Solution {
    static List<List<Integer>> list = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        for(int i = 0; i <= n; i++)
            list.add(new ArrayList<>());
        
        for(int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        int answer = func(n);
        return answer;
    }
    
    static int func(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            count = size;
            while(size > 0) {
                int now = queue.poll();
                for(int next : list.get(now)) {
                    if(!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
                size--;
            }
        }
        return count;
    }
}