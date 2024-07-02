import java.io.*;
import java.util.*;

class Main{
    static int[][] arr;
    static int n;
    static int m;
    
    static int[] back(int[] xy, int d) {
        switch(d) {
            case 0: xy[0] += 1;
                break;
            case 1: xy[1] -= 1;
                break;
            case 2: xy[0] -= 1;
                break;
            case 3: xy[1] += 1;
                break;
        }
        return xy;
    }
    
    static int[] go(int[] xy, int d) {
        switch(d) {
            case 0: xy[0] -= 1;
                break;
            case 1: xy[1] += 1;
                break;
            case 2: xy[0] += 1;
                break;
            case 3: xy[1] -= 1;
                break;
        }
        return xy;
    }
    
    static int turn(int d) {
        switch(d) {
            case 0: d = 3;
                break;
            case 1: d = 0;
                break;
            case 2: d = 1;
                break;
            case 3: d = 2;
                break;
        }
        return d;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        function(r, c, d);
    }
    
    static void function(int r, int c, int d) {
        int count = 0;
        while(arr[r][c] != 1) {
            int[] xy = {r, c};
            if(arr[r][c] == 0) {
                arr[r][c] = 2;
                count++;
            }
            
            if(arr[r-1][c] == 0 || arr[r][c-1] == 0 ||
               arr[r+1][c] == 0 || arr[r][c+1] == 0) {
                d = turn(d);
                xy = go(xy, d);
                if(arr[xy[0]][xy[1]] == 0) {
                    r = xy[0];
                    c = xy[1];
                }
            } else {
                xy = back(xy, d);
                r = xy[0];
                c = xy[1];
            }
        }
        System.out.println(count);
    }
}