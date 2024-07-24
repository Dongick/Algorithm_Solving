import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static int n;
    static int max = 0, count = 1;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            return o1[1]!=o2[1] ? o1[1]-o2[1] : o1[0]-o2[0];
        });
        
        dfs(0);
        sb.append(count);
        System.out.println(sb);
    }

    static void dfs(int idx) {
        for(int i = idx+1; i < n; i++) {
            if(arr[idx][1] <= arr[i][0]) {
                count++;
                dfs(i);
                return;
            }
        }
    }
}