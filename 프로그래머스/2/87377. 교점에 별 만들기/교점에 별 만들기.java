import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<long[]> list = new ArrayList<>();
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        
        for(int i = 0; i < line.length; i++) {
            for(int j = i + 1; j < line.length; j++) {
                long denominator = (long)line[i][0] * line[j][1] - (long)line[i][1] * line[j][0];
                if(denominator == 0)
                    continue;
                long xNumerator = (long)line[i][1] * line[j][2] - (long)line[i][2] * line[j][1];
                long yNumerator = (long)line[i][2] * line[j][0] - (long)line[i][0] * line[j][2];
                if(xNumerator % denominator == 0 && yNumerator % denominator == 0) {
                    long x = xNumerator / denominator;
                    long y = yNumerator / denominator;
                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                    maxX = Math.max(maxX, x);
                    maxY = Math.max(maxY, y);
                    list.add(new long[] {x, y});
                }
            }
        }
        
        Collections.sort(list, (o1, o2) -> {
            if(o1[1] == o2[1])
                return Long.compare(o1[0], o2[0]);
            else
                return Long.compare(o2[1], o1[1]);
        });
        
        String[] answer = new String[(int)(maxY - minY) + 1];
        for(int i = 0; i <= maxY - minY; i++)
            answer[i] = ".".repeat((int)(maxX - minX) + 1);
        
        StringBuilder sb;
        for(long[] num : list) {
            sb = new StringBuilder(answer[(int)(Math.abs(num[1] - maxY))]);
            sb.setCharAt((int)(num[0] - minX), '*');
            answer[(int)(Math.abs(num[1] - maxY))] = sb.toString();
        }
        
        return answer;
    }
}