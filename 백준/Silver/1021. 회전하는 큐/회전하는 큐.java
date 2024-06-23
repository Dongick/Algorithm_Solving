import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> deque = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }
        
        int[] numArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        
        int count = 0;
        for(int n : numArr) {
            int pollIndex = deque.indexOf(n);
            int halfIndex;
            
            if(deque.size() % 2 == 0) {
                halfIndex = deque.size() / 2 - 1;
            } else {
                halfIndex = deque.size() / 2;
            }
            
            if(pollIndex <= halfIndex) {
                for(int i = 0; i < pollIndex; i++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
                deque.pollFirst();
            } else {
                for(int i = 0; i < deque.size() - pollIndex; i++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }
                deque.pollFirst();
            }
        }
        System.out.println(count);
    }
}