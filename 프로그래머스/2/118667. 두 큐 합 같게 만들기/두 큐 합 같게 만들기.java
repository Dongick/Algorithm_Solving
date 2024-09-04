import java.util.*;

class Solution {
    static Queue<Integer> que1 = new LinkedList<>();
    static Queue<Integer> que2 = new LinkedList<>();
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        long queue1Sum = 0;
        long queue2Sum = 0;
        int size = queue1.length * 3 - 3;
        for(int i = 0; i < queue1.length; i++) {
            queue1Sum += queue1[i];
            queue2Sum += queue2[i];
            que1.offer(queue1[i]);
            que2.offer(queue2[i]);
        }
        
        if((queue1Sum + queue2Sum) % 2 == 1)
            return answer;
        answer = func(queue1Sum, queue2Sum, size);
        
        return answer;
    }
                
    static int func(long queue1Sum, long queue2Sum, int size) {
        int count = 0;
        while(count <= size) {
            if(queue1Sum == queue2Sum)
                break;
            if(queue1Sum > queue2Sum) {
                int num = que1.poll();
                que2.offer(num);
                queue1Sum -= num;
                queue2Sum += num;
            } else {
                int num = que2.poll();
                que1.offer(num);
                queue2Sum -= num;
                queue1Sum += num;
            }
            count++;
        }
        if(count > size)
            count = -1;
        return count;
    }
}