import java.util.*;

class Solution {
    static int limit;
    static int n;
    static int winner = 0;
    static int[] winnerArr;
    static Map<Integer, Integer> aMap;
    static Map<Integer, Integer> bMap;
    
    public int[] solution(int[][] dice) {
        n = dice.length;
        limit = (int)Math.pow(6, n / 2);
        winnerArr = new int[n / 2];
        boolean[] visited = new boolean[n];
        visited[0] = true;
        
        func(1, visited, dice, 1);
        int[] answer = winnerArr;
        return answer;
    }
    
    static void func(int count, boolean[] visited, int[][] dice, int idx) {
        if(count == n / 2) {
            aMap = new HashMap<>();
            bMap = new HashMap<>();
            
            for(int i = 0; i < limit; i++) {
                func2(i, visited, dice);
            }
            
            List<Integer> aKeySet = new ArrayList<>(aMap.keySet());
            List<Integer> bKeySet = new ArrayList<>(bMap.keySet());
            
            Collections.sort(aKeySet);
            Collections.sort(bKeySet);
            
            int aWin = 0;
            int a = 0;
            int b = 0;
            int bSum = 0;
            int draw = 0;
            while(a != aKeySet.size() && b != bKeySet.size()) {
                if(aKeySet.get(a) > bKeySet.get(b)) {
                    aWin += bMap.get(bKeySet.get(b)) * aMap.get(aKeySet.get(a));
                    bSum += bMap.get(bKeySet.get(b));
                    b++;
                    
                } else if(aKeySet.get(a) < bKeySet.get(b)) {
                    a++;
                    if(a != aKeySet.size())
                        aWin += bSum * aMap.get(aKeySet.get(a));
                    
                } else {
                    draw += aMap.get(aKeySet.get(a)) * bMap.get(bKeySet.get(b));
                    bSum += bMap.get(bKeySet.get(b));
                    a++;
                    b++;
                    if(a != aKeySet.size())
                        aWin += bSum * aMap.get(aKeySet.get(a));
                }
            }
            
            if(b == bKeySet.size()) {
                for(int i = a + 1; i < aKeySet.size(); i++) {
                    aWin += bSum * aMap.get(aKeySet.get(i));
                }
            }
            
            int bWin = (int)Math.pow(6, n) - aWin - draw;
            
            if(aWin > bWin) {
                if(winner < aWin) {
                    winner = aWin;
                    int num = 0;
                    for(int i = 0; i < n; i++) {
                        if(visited[i]) {
                            winnerArr[num] = i + 1;
                            num++;
                        }
                    }
                }
            } else {
                if(winner < bWin) {
                    winner = bWin;
                    int num = 0;
                    for(int i = 0; i < n; i++) {
                        if(!visited[i]) {
                            winnerArr[num] = i + 1;
                            num++;
                        }
                    }
                }
            }
            
            return;
        }
        
        for(int i = idx; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                func(count+1, visited, dice, i + 1);
                visited[i] = false;
            }
        }
    }
    
    static void func2(int num, boolean[] visited, int[][] dice) {
        int a = 0;
        int b = 0;
        int aTemp = num;
        int bTemp = num;
        int i = 0;
        while(i != n) {
            if(visited[i]) {
                a += dice[i][aTemp % 6];
                aTemp /= 6;
            } else {
                b += dice[i][bTemp % 6];
                bTemp /= 6;
            }
            i++;
        }
        
        if(aMap.containsKey(a)) {
            int count = aMap.get(a);
            aMap.replace(a, count + 1);
        } else {
            aMap.put(a, 1);
        }
        
        if(bMap.containsKey(b)) {
            int count = bMap.get(b);
            bMap.replace(b, count + 1);
        } else {
            bMap.put(b, 1);
        }
    }
}