import java.util.*;
import java.io.*;

class Main {
    static char[][] arr;
    static int num;
    static List<int[]> list = new ArrayList<>();
    static int n = 5;
    static int[][] temp;
    static int result = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[n][n];
        num = 0;
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == '*') {
                    num++;
                    list.add(new int[] {i, j});
                }
            }
        }
        temp = new int[n][n];
        dfs(0,0);
        System.out.println(result);
    }

    static void dfs(int idx, int count) {
        if(count == num) {
            checkLinked();
            return;
        }
        if(idx >= n*n)
            return;
        int x = idx / n;
        int y = idx % n;
        temp[x][y] = 1;
        dfs(idx+1, count+1);
        temp[x][y] = 0;
        dfs(idx+1, count);
    }

    static void checkLinked() {
        List<int[]> checkList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(temp[i][j] == 1)
                    checkList.add(new int[] {i, j});
            }
            if(checkList.size() == num)
                break;
        }
        if(isConnected(checkList))
            minMove(checkList);

        
    }

    static boolean isConnected(List<int[]> checkList) {
        boolean[][] check = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(checkList.get(0));
        check[checkList.get(0)[0]][checkList.get(0)[1]] = true;
        int count = 1;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            for(int i = 0; i < 4; i++) {
                int x = current[0] + dx[i];
                int y = current[1] + dy[i];
                if(x >= 0 && y >= 0 && x < 5 && y < 5 && temp[x][y] == 1 && !check[x][y]) {
                    check[x][y] = true;
                    queue.add(new int[] {x, y});
                    count++;
                }
            }
        }
        return count == checkList.size();
    }

    static void minMove(List<int[]> checkList) {
        boolean[][] check = new boolean[n][n];
        int tempResult = 0;
        for(int i = 0; i < num; i++) {
            int beforeX = list.get(i)[0];
            int beforeY = list.get(i)[1];
            int minDistance = 8;
            int afterX = 0, afterY = 0;
            for(int j = 0; j < num; j++) {
                int tempX = checkList.get(j)[0];
                int tempY = checkList.get(j)[1];
                if(!check[tempX][tempY]) {
                    int distance = Math.abs(tempX - beforeX) + Math.abs(tempY - beforeY);
                    if(minDistance >= distance) {
                        afterX = tempX;
                        afterY = tempY;
                        minDistance = distance;
                    }
                }
            }
            check[afterX][afterY] = true;
            tempResult += minDistance;
        }
        result = Math.min(tempResult, result);
    }
}