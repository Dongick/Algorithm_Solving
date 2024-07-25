import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static int blue = 0;
    static int white = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0, 0, n, n);
        sb.append(white).append("\n").append(blue);
        System.out.println(sb);
    }

    static void func(int startX, int startY, int endX, int endY) {
        for(int i = startX; i < endX; i++) {
            for(int j = startY; j < endY; j++) {
                if(arr[startX][startY] != arr[i][j]) {
                    func(startX, startY, (startX + endX)/2, (startY + endY)/2);
                    func((startX + endX)/2, startY, endX, (startY + endY)/2);
                    func(startX, (startY + endY)/2, (startX + endX)/2, endY);
                    func((startX + endX)/2, (startY + endY)/2, endX, endY);
                    return;
                }
            }
        }
        if(arr[startX][startY] == 1)
            blue += 1;
        else
            white += 1;
    }
}