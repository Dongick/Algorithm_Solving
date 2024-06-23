import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] whiteArr = new char[8][8];
        char[][] blackArr = new char[8][8];
        whiteArr[0][0] = 'W';
        blackArr[0][0] = 'B';
        for(int i = 0; i < 8; i++) {
            if(i != 0) {
                if(whiteArr[i - 1][0] == 'W') {
                    whiteArr[i][0] = 'B';
                    blackArr[i][0] = 'W';
                } else {
                    whiteArr[i][0] = 'W';
                    blackArr[i][0] = 'B';
                }
            }
            for(int j = 0; j < 7; j++) {
                if(whiteArr[i][j] == 'W') {
                    whiteArr[i][j + 1] = 'B';
                    blackArr[i][j + 1] = 'W';
                } else {
                    whiteArr[i][j + 1] = 'W';
                    blackArr[i][j + 1] = 'B';
                }
            }
        }
        char[][] chessArr = new char[N][M];
        for(int i = 0; i < N; i++) {
            String chess = br.readLine();
            chessArr[i] = chess.toCharArray();
        }
        
        int result = 64;
        for(int i = 0; i <= N - 8; i++) {
            for(int j = 0; j <= M - 8; j++) {
                int temp1 = 0;
                int temp2 = 0;
                for(int k = 0; k < 8; k++) {
                    for(int s = 0; s < 8; s++) {
                        if(chessArr[i + k][j + s] == whiteArr[k][s]) {
                            temp2++;
                        } else {
                            temp1++;
                        }
                    }
                }
                int temp = Math.min(temp1, temp2);
                if(result > temp) {
                    result = temp;
                }
            }
        }
        System.out.println(result);
    }
}