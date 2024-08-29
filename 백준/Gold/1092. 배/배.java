import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] crane = new int[n];
        for(int i = 0; i < n; i++)
            crane[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(crane);
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] box = new int[m];
        for(int i = 0; i < m; i++)
            box[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(box);
        
        if(crane[n-1] < box[m-1]) {
            sb.append(-1);
            System.out.println(sb);
            return;
        }

        int result = 0;
        int count = 0;
        boolean[] check = new boolean[m];
        while(count < m) {
            int idx = m-1;
            for(int i = n-1; i >= 0; i--) {
                for(int j = idx; j >= 0; j--) {
                    if(crane[i] >= box[j] && !check[j]) {
                        check[j] = true;
                        idx = j - 1;
                        count++;
                        break;
                    }
                }
            }
            result++;
        }
        sb.append(result);
        System.out.println(sb);
    }
}