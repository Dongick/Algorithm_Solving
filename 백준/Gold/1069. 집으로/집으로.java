import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        double time = 0;
        double road = Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
        if(D > T) {
            while(road > 2 * D) {
                road -= D;
                time += T;
            }

            if(road > 2 * T) {
                road -= D;
                time += T;

                if(Math.abs(road) > T)
                    time +=T;
                else
                    time += Math.abs(road);
            } else if(road > T && road <= 2 * T){
                if(Math.abs(road - D) + T >= road)
                    time += road;
                else {
                    road -= D;
                    time += T;
                    time += Math.abs(road);
                }
            } else
                time += road;
        } else {
            time += road;
        }
        System.out.println(time);
        sb.append(sb);
    }
}