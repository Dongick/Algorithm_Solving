import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double sumScore = 0;
        double sumGrade = 0;
        for(int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double score = Float.parseFloat(st.nextToken());
            String grade = st.nextToken();
            double gradeScore = gradeCase(grade);
            if(Double.compare(-1, gradeScore) == 0)
                continue;
            sumScore += score;
            sumGrade += gradeScore * score;
        }
        
        System.out.println(sumGrade / sumScore);
    }

    static double gradeCase(String grade) {
        double gradeScore = 0;
        switch(grade) {
            case "A+":
                gradeScore = 4.5;
                break;
            case "A0":
                gradeScore = 4.0;
                break;
            case "B+":
                gradeScore = 3.5;
                break;
            case "B0":
                gradeScore = 3.0;
                break;
            case "C+":
                gradeScore = 2.5;
                break;
            case "C0":
                gradeScore = 2.0;
                break;
            case "D+":
                gradeScore = 1.5;
                break;
            case "D0":
                gradeScore = 1.0;
                break;
            case "F":
                gradeScore = 0.0;
                break;
            default: gradeScore = -1;
                break;
        }
        return gradeScore;
    }
}