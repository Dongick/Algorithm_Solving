import java.util.*;
import java.io.*;

class Main {
    static List<List<int[]>> list = new ArrayList<>();
    static boolean[] check;
    static int max = 0;
    static int node = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int v = Integer.parseInt(br.readLine());
        for(int i = 0; i <= v; i++)
            list.add(new ArrayList<>());
        for(int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int num;
            while((num = Integer.parseInt(st.nextToken())) != -1) {
                int cost = Integer.parseInt(st.nextToken());
                list.get(n).add(new int[] {num, cost});
            }
        }
        check = new boolean[v+1];
        dfs(1, 0);
        check = new boolean[v+1];
        dfs(node, 0);
        sb.append(max);
        
        System.out.println(sb);
    }

    static void dfs(int num, int cost) {
        if(cost > max) {
            max = cost;
            node = num;
        }
        check[num] = true;

        for(int[] next : list.get(num)) {
            if(!check[next[0]]) {
                dfs(next[0], cost + next[1]);
            }
        }
    }
}