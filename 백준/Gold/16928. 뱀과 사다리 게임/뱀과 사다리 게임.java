import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static int[] result = new int[101];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n+m][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = n; i < n+m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        sb.append(bfs() - 1);
        System.out.println(sb);
    }

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        result[1] = 1;
        
        while(!queue.isEmpty()) {
            boolean check = false;
            int num = queue.poll();
            for(int[] number : arr) {
                if(number[0] == num) {
                    if(result[number[1]] == 0 || result[number[1]] > result[number[0]]) {
                        queue.offer(number[1]);
                        result[number[1]] = result[number[0]];
                        check = true;
                        break;
                    } else
                        check = true;
                        break;
                }
            }
            if(!check) {
                for(int i = 1; i <= 6; i++) {
                    if(num + i <= 100 && (result[num + i] == 0 || result[num + i] > result[num] + 1)) {
                        queue.offer(num + i);
                        result[num + i] = result[num] + 1;
                    }
                }
            }
        }
        return result[100];
    }
}