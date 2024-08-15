import java.util.*;
import java.io.*;

class Main {
    static int n, w;
    static int[][] arr;
    static int[][] accident;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        w = Integer.parseInt(br.readLine());
        arr = new int[w + 1][w + 1];
        accident = new int[w + 1][2];

        for(int i = 1; i <= w; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            accident[i][0] = Integer.parseInt(st.nextToken());
            accident[i][1] = Integer.parseInt(st.nextToken());
        }
        sb.append(dp(1, 0, 0)).append("\n");

        int oneIdx = 0;
        int twoIdx = 0;
        for(int i = 1; i <= w; i++) {
            int oneDistance = distance(0, oneIdx, i);
            if(arr[oneIdx][twoIdx] - oneDistance == arr[i][twoIdx]) {
                sb.append(1).append("\n");
                oneIdx = i;
            } else {
                sb.append(2).append("\n");
                twoIdx = i;
            }
        }
        System.out.println(sb);
    }

    static int dp(int acIdx, int oneIdx, int twoIdx) {
        if(acIdx > w)
            return 0;

        if(arr[oneIdx][twoIdx] != 0)
            return arr[oneIdx][twoIdx];

        int oneMove = dp(acIdx+1, acIdx, twoIdx) + distance(0, oneIdx, acIdx);
        int twoMove = dp(acIdx+1, oneIdx, acIdx) + distance(1, twoIdx, acIdx);

        return arr[oneIdx][twoIdx] = Math.min(oneMove, twoMove);
    }

    static int distance(int car, int startIdx, int endIdx) {
        int x = 0;
        int y = 0;
        if(startIdx == 0) {
            if(car == 0) {
                x = 1;
                y = 1;
            } else {
                x = n;
                y = n;
            }
        } else {
            x = accident[startIdx][0];
            y = accident[startIdx][1];
        }
        return Math.abs(accident[endIdx][0] - x) + Math.abs(accident[endIdx][1] - y);
    }
}