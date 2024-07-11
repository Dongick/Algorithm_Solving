import java.util.*;
import java.io.*;

class Entry{
    int age;
    String name;
    int index;

    public Entry(int age, String name, int index) {
        this.age = age;
        this.name = name;
        this.index = index;
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Entry> entryList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            entryList.add(new Entry(Integer.parseInt(st.nextToken()), st.nextToken(), i));
        }
        entryList.sort((o1, o2) -> {
            if(o1.age != o2.age) 
                return Integer.compare(o1.age, o2.age);
            else
                return Integer.compare(o1.index, o2.index);
        });
        for(Entry entry : entryList) {
            sb.append(entry.age).append(" ").append(entry.name).append("\n");
        }
        System.out.println(sb);
    }
}