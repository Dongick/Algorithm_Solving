import java.util.*;
import java.io.*;

class Main {
    static List<List<Integer>> list;
    static int[] arr;
    static boolean check;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        while(k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            arr = new int[V+1];
            for(int i = 0; i <= V; i++)
                list.add(new ArrayList<>());
            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                list.get(u).add(v);
                list.get(v).add(u);
            }
            check = true;

            for(int i = 1; i <= V; i++) {
                if(!check)
                    break;
                if(arr[i] == 0)
                    dfs(i, 1);
            }

            if(check)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int idx, int color) {
        arr[idx] = color;
        
        for(int num : list.get(idx)) {
            if(arr[num] == color) {
                check = false;
                return;
            }
            if(arr[num] == 0) {
                dfs(num, -color);
            }
        }
    }
}