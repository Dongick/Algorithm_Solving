import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        func(0, 0, n, n);
        System.out.println(sb);
    }

    static void func(int startX, int startY, int endX, int endY) {
        for(int i = startX; i < endX; i++) {
            for(int j = startY; j < endY; j++) {
                if(arr[startX][startY] != arr[i][j]) {
                    sb.append("(");
                    func(startX, startY, (startX + endX)/2, (startY + endY)/2);
                    func(startX, (startY + endY)/2, (startX + endX)/2, endY);
                    func((startX + endX)/2, startY, endX, (startY + endY)/2);
                    func((startX + endX)/2, (startY + endY)/2, endX, endY);
                    sb.append(")");
                    return;
                }
            }
        }
        if(arr[startX][startY] == 1)
            sb.append(1);
        else
            sb.append(0);
    }
}