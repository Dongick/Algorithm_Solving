import java.util.*;
import java.io.*;

class Main {
    static int n;
    static List<List<Integer>> list;
    static int[] result;
    static int count = 1;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            list.add(new ArrayList<>());
        result = new int[n+1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }
        for(int i = 1; i <= n; i++)
            Collections.sort(list.get(i));
        dfs(r);

        for(int i = 1; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        result[start] = count;
        while(!queue.isEmpty()) {
            int num = queue.poll();
            for(int number : list.get(num)) {
                if(result[number] == 0) {
                    result[number] = ++count;
                    queue.offer(number);
                }
            }
        }
    }
}