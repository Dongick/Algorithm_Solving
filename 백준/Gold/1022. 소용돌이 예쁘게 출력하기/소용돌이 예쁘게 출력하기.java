import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        int[][] arr = new int[r2 - r1 + 1][c2 - c1 + 1];

        for(int i = r1; i <= r2; i++) {
            for(int j = c1; j <= c2; j++) {
                arr[i-r1][j-c1] = calculate(i, j);
            }
        }
        
        int digitMax = Math.max(Math.max(arr[0][0], arr[r2 - r1][0]), Math.max(arr[0][c2 - c1], arr[r2 - r1][c2 - c1]));
        int digit = 1;
        while(digitMax >= 10) {
            digitMax = digitMax / 10;
            digit ++;
        }
        
        for(int i = 0; i <= r2 - r1; i++) {
            for(int j = 0; j <= c2 - c1; j++) {
                int temp = arr[i][j];
                int count = digit - 1;
                System.out.format("%" + digit + "d ", arr[i][j]);
            }
            System.out.println();
        }
    }
    
    static int calculate(int row, int column){
        int border = Math.max(Math.abs(row),Math.abs(column));
        int min = (int) Math.pow(2*border-1,2)+1;

        if(row == border){
            return min + 7*border -1 + column;
        }

        if(column == -border){
            return min + 5*border -1 + row;
        }

        if(row == -border){
            return min + 3*border -1 - column;
        }

        return min + border -1 - row;
    }
}