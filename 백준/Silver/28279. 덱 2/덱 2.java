import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    deque.offer(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    if(deque.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(deque.poll()).append("\n");
                    break;
                case 4:
                    if(deque.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(deque.pollLast()).append("\n");
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
                    break;
                case 6:
                    if(deque.isEmpty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;
                case 7:
                    if(deque.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(deque.peek()).append("\n");
                    break;
                case 8:
                    if(deque.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(deque.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}