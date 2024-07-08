import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int trueN = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < trueN; i++)
            list.add(Integer.parseInt(st.nextToken()));
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] member = new int[num];
            for(int j = 0; j < num; j++)
                member[j] = Integer.parseInt(st.nextToken());
            queue.offer(member);
        }

        int[] limit = queue.peek();
        while(!queue.isEmpty()) {
            int[] member = queue.poll();
            boolean check = false;
            for(int i = 0; i < member.length; i++) {
                for(int j = 0; j < list.size(); j++) {
                    if(member[i] == list.get(j))
                        check = true;
                    if(check)
                        break;
                }
                if(check)
                    break;
            }
            if(check) {
                for(int i = 0; i < member.length; i++) {
                    boolean inCheck = false;
                    for(int j = 0; j < list.size(); j++) {
                        if(member[i] == list.get(j))
                            inCheck = true;
                    }
                    if(!inCheck)
                        list.add(member[i]);
                }
                limit = queue.peek();
            } else {
                queue.offer(member);
                if(limit == queue.peek())
                    break;
            }
        }
        System.out.println(queue.size());
    }
}