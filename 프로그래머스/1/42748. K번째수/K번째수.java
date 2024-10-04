import java.util.stream.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++) {
            int a = commands[i][0] - 1;
            int b = commands[i][1] - 1;
            int c = commands[i][2] - 1;
            int[] arr = IntStream.rangeClosed(a, b)
                .map(j -> array[j])
                .sorted()
                .toArray();
            answer[i] = arr[c];
        }
        return answer;
    }
}