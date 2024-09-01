import java.util.*;

class Solution {
    static List<List<Integer>> list = new ArrayList<>();
    static int[] incommingArr;
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int maxIdx = 0;
        for(int[] edge : edges)
            maxIdx = Math.max(maxIdx, Math.max(edge[0], edge[1]));
        for(int i = 0; i <= maxIdx; i++)
            list.add(new ArrayList<>());
        incommingArr = new int[maxIdx + 1];
        
        for(int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            incommingArr[edges[i][1]]++;
        }
        int vertex = findVertex(maxIdx);
        int donut = 0;
        int stick = 0;
        int eight = 0;
        for(int n : list.get(vertex)) {
            int num = func(n);
            if(num == 1)
                donut++;
            if(num == 2)
                stick++;
            if(num == 3)
                eight++;
        }
        answer[0] = vertex;
        answer[1] = donut;
        answer[2] = stick;
        answer[3] = eight;
        
        return answer;
    }
    
    static int findVertex(int maxIdx) {
        int vertex = 0;
        for(int i = 1; i <= maxIdx; i++) {
            if(list.get(i).size() >= 2 && incommingArr[i] == 0) {
                vertex = i;
                break;
            }
        }
        return vertex;
    }
    
    static int func(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while(!queue.isEmpty()) {
            int num = queue.poll();
            
            if(list.get(num).size() == 2)
                return 3;
            for(int i : list.get(num)) {
                if(i == n)
                    return 1;
                queue.offer(i);
            }
        }
        return 2;
    }
}