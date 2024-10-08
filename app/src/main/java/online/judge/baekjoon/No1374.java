package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 강의실
 * 골드 5
 */
public class No1374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        List<Class> classList = new ArrayList<>();
        while(n --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            classList.add(new Class(num, start, end));
        }

//        classList.sort((o1, o2) -> {
//            if(o1.end == o2.end){
//                return o1.start - o2.start;
//            }
//            return o1.end - o2.end;
//        });
        classList.sort(Comparator.comparingInt((Class o) -> o.end)
                .thenComparingInt(o -> o.start));

        List<List<Class>> classRooms = new ArrayList<>();

        for(Class cls : classList){

            boolean flag = true;
            for(List<Class> classRoom : classRooms){
                Class temp = classRoom.get(classRoom.size() - 1);
                if(temp.end <= cls.start){
                    classRoom.add(cls);
                    flag = false;
                    break;
                }
            }
            if(flag){
                List<Class> newClass = new ArrayList<>();
                newClass.add(cls);
                classRooms.add(newClass);
            }
        }

        System.out.println(classRooms.size());
    }
    static class Class{
        int number;
        int start;
        int end;

        public Class(int number, int start, int end) {
            this.number = number;
            this.start = start;
            this.end = end;
        }
    }
}
