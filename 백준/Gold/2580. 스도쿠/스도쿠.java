import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static List<int[]> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[9][9];
        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0)
                    list.add(new int[] {i, j});
            }
        }
        sudocu(0);
        System.out.println(sb);
    }

    static void sudocu(int num) {
        if(num == list.size()) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        
        int x = list.get(num)[0];
        int y = list.get(num)[1];
        for(int i = 1; i <= 9; i++) {
            if(check(x, y, i)) {
                arr[x][y] = i;
                sudocu(num+1);
                arr[x][y] = 0;
            }
        }
    }

    static boolean check(int x, int y, int val) {
        for(int i = 0; i < 9; i++) {
            if(arr[i][y] == val)
                return false;
            if(arr[x][i] == val)
                return false;
        }
        int row = x / 3;
        int col = y / 3;
        for(int i = 3 * row; i < 3 * row + 3; i++) {
            for(int j = 3 * col; j < 3 * col + 3; j++) {
                if(arr[i][j] == val)
                    return false;
            }
        }
        return true;
    }
}