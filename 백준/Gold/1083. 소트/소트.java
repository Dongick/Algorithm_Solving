import java.util.*;
import java.io.*;

class Main {
    static int n, s;
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        s = Integer.parseInt(br.readLine());

        sort();
        for(int i = 0; i < n; i++)
            sb.append(arr[i]).append(" ");

        System.out.println(sb);
    }

    static void sort() {
        Comparator<int[]> comp = new Comparator<>() {
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        };

        for(int i = 0; i < n; i++) {
            PriorityQueue<int[]> queue = new PriorityQueue<>(comp);
            for(int j = i; j < n; j++) {
                queue.offer(new int[] {arr[j], j});
            }

            while(!queue.isEmpty()) {
                int[] num = queue.poll();
                if(s >= num[1] - i && arr[i] < num[0]) {
                    int temp = arr[num[1]];
                    for(int j = num[1]; j > i; j--) {
                        arr[j] = arr[j - 1];
                    }
                    arr[i] = temp;
                    s -= (num[1] - i);
                    break;
                }
            }
        }
    }
}