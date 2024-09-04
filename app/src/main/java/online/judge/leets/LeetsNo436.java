package online.judge.leets;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LeetsNo436 {
    public static void main(String[] args) {
        LeetsNo436Solution sol = new LeetsNo436Solution();
        sol.findRightInterval(new int[][]{{-100,-92},{-99,-49},{-98,-24},{-97,-38},{-96,-65},{-95,-22},
        {-94,-49},{-93,-14},{-92,-68},{-91,-81},{-90,-49},{-89,-23},{-88,5},{-87,-44},{-86,2},{-85,-81},
        {-84,-56},{-83,-53},{-82,-41},{-81,-68},{-80,-76},{-79,-9},{-78,-68},{-77,-19},{-76,-15},{-75,-41},
        {-74,26},{-73,6},{-72,-55},{-71,-35},{-70,28},{-69,-42},{-68,-55},{-67,1},{-66,-55},{-65,-31},{-64,16},
        {-63,-13},{-62,18},{-61,-39},{-60,8},{-59,14},{-58,36},{-57,-20},{-56,30},{-55,-9},{-54,-25},{-53,39},
        {-52,43},{-51,7},{-50,-48},{-49,5},{-48,-39},{-47,-2},{-46,23},{-45,46},{-44,-19},{-43,54},{-42,-11},
        {-41,-37},{-40,-17},{-39,28},{-38,12},{-37,-12},{-36,-34},{-35,19},{-34,44},{-33,-24},{-32,-3},{-31,3},
        {-30,69},{-29,53},{-28,8},{-27,-13},{-26,40},{-25,-10},{-24,40},{-23,14},{-22,4},{-21,49},{-20,-4},{-19,76}
        ,{-18,12},{-17,-15},{-16,2},{-15,81},{-14,-8},{-13,-8},{-12,40},{-11,88},{-10,79},{-9,15},{-8,-2},{-7,76}
        ,{-6,47},{-5,62},{-4,13},{-3,35},{-2,37},{-1,44},{0,2},{1,99},{2,74},{3,32},{4,42},{5,64},{6,84},{7,105}});

    }
}
class LeetsNo436Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] answer = new int[intervals.length];
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            answer[i] = -1;
            map.put(intervals[i],i);
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return (i1[0] - i2[0]);
            }
        });

        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            int lt = 0;
            int rt = intervals.length-1;
            while(lt <= rt){
                int mid = (lt + rt) / 2;
                if(intervals[mid][0] == end){
                    answer[map.get(interval)] = map.get(intervals[mid]);
                    break;
                }else if(intervals[mid][0] < end){
                    lt = mid+1;
                }else{
                    if(answer[map.get(interval)] == -1){
                        answer[map.get(interval)] = map.get(intervals[mid]);
                    }else{
                        answer[map.get(interval)] = Math.min(map.get(intervals[mid]), answer[map.get(interval)]);
                    }
                    rt = mid-1;
                }
            }
        }

        return answer;
    }
}