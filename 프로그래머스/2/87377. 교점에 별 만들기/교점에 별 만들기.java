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
        int idx = 0;
        long[] duplCheck = new long[2];
        for(long i = maxY; i >= minY; i--) {
            answer[(int)(maxY - i)] = "";
            for(long j = minX; j <= maxX; j++) {
                if(idx < list.size() && list.get(idx)[0] == j && list.get(idx)[1] == i) {
                    answer[(int)(maxY - i)] += "*";
                    duplCheck[0] = j;
                    duplCheck[1] = i;
                    idx++;
                    while(idx < list.size() && duplCheck[0] == list.get(idx)[0] && duplCheck[1] == list.get(idx)[1])
                        idx++;
                } else
                    answer[(int)(maxY - i)] += ".";
            }
        }
        return answer;
    }
}