import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] length = new int[6];
        int maxHorizontal = 0;
        int maxVertical = 0;
        int maxHorizontalI = 0;
        int maxVerticalI = 0;
        for(int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if(n1 == 1 || n1 == 2) {
                if(maxHorizontal < n2) {
                    maxHorizontal = n2;
                    maxHorizontalI = i;
                }
            } else {
                if(maxVertical < n2) {
                    maxVertical = n2;
                    maxVerticalI = i;
                }
            }
            length[i] = n2;
        }
        int smallSquare = 1;
        if(maxHorizontalI == 0)
            smallSquare *= Math.abs(length[1] - length[5]);
        else if(maxHorizontalI == 5)
            smallSquare *= Math.abs(length[0] - length[4]);
        else
            smallSquare *= Math.abs(length[maxHorizontalI-1] - length[maxHorizontalI+1]);
        
        if(maxVerticalI == 0)
            smallSquare *= Math.abs(length[1] - length[5]);
        else if(maxVerticalI == 5)
            smallSquare *= Math.abs(length[0] - length[4]);
        else
            smallSquare *= Math.abs(length[maxVerticalI-1] - length[maxVerticalI+1]);
        
        System.out.println(k * (maxVertical * maxHorizontal - smallSquare));
    }
}