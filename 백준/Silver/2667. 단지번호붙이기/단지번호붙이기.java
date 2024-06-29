import java.io.*;
import java.util.*;

class Main{
    static int n;
    static int[][] arr;
    static boolean[][] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        check = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            arr[i] = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray();
        }
        num = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 1 && !check[i][j]) {
                    num++;
                    dfs(i, j);
                }
            }
        }
        int[] result = new int[num];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] > 0) {
                    result[arr[i][j] - 1]++;
                }
            }
        }
        Arrays.sort(result);
        System.out.println(num);
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    
    static void dfs(int x, int y) {
        check[x][y] = true;
        arr[x][y] = num;
        int afterX, afterY;
        for(int i = 0; i < 4; i++) {
            afterX = x + dx[i];
            afterY = y + dy[i];
            if(afterX >= 0 && afterY >= 0 && afterX < n && afterY < n) {
                if(arr[afterX][afterY] == 1 && !check[afterX][afterY])
                    dfs(afterX, afterY);
            }
        }
    }
}