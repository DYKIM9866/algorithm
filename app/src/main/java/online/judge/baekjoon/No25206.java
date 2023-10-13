package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 너의 평점은
 * 완료 230927
 */
public class No25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        float scoreSum = 0;
        float gradeSum = 0;

        for(int i=0;i<20;i++){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            st.nextToken();
            float score = Float.parseFloat(st.nextToken());
            String grade = st.nextToken();
            if(!grade.equals("P")){
                scoreSum += score;
                gradeSum += score * getGradeScore(grade);
            }
        }
        System.out.println(gradeSum/scoreSum);

    }

    private static float getGradeScore(String grade) {
        float result;
        switch (grade){
            case "A+":
                result = 4.5f;
                break;
            case "A0":
                result = 4.0f;break;
            case "B+":
                result = 3.5f;break;
            case "B0":
                result = 3.0f;break;
            case "C+":
                result = 2.5f;break;
            case "C0":
                result = 2.0f;break;
            case "D+":
                result = 1.5f;break;
            case "D0":
                result = 1.0f;break;
            default:
                result = 0.0f;break;
        }
        return result;
    }

}
