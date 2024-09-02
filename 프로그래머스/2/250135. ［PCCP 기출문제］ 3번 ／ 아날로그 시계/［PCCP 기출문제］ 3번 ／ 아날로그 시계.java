class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        
        double ds1 = h1 * 3600 + m1 * 60 + s1;
        double ds2 = h2 * 3600 + m2 * 60 + s2;
        
        if(ds1 == 0 || ds1 == 43200)
            answer++;
        if(ds1 < 43200 && ds2 >= 43200)
            answer--;
        
        while(ds1 < ds2) {
            double now_h = (ds1 / 120) % 360;
            double now_m = (ds1 / 10) % 360;
            double now_s = (ds1 *6) % 360;
            
            ds1 += 1;
            
            double next_h = (ds1 / 120) % 360;
            double next_m = (ds1 / 10) % 360;
            double next_s = (ds1 *6) % 360;
            
            next_h = (next_h == 0) ? 360 : next_h;
            next_m = (next_m == 0) ? 360 : next_m;
            next_s = (next_s == 0) ? 360 : next_s;
            
            if(now_s < now_h && next_s >= next_h)
                answer++;
            if(now_s < now_m && next_s >= next_m)
                answer++;
        }
        
        return answer;
    }
}