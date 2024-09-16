import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class _161_MinimumTimeDifference {
    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");
        System.out.println(findMinDifference(timePoints));
    }
    public static int findMinDifference(List<String> timePoints){
        int n = timePoints.size();
        int[] minutes = new int[n];
        for (int i = 0; i < n; i++) {
            String time  = timePoints.get(i);
            String hoursSubStr = time.substring(0,2); //HH
            String minSubStr = time.substring(3); // MM
            int hoursInMinutes = Integer.parseInt(hoursSubStr); // HH in int
            int min = Integer.parseInt(minSubStr); // MM in int
            minutes[i] = hoursInMinutes * 60 + min;
        }
        Arrays.sort(minutes);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            result = Math.min(result, minutes[i] - minutes[i-1]);
        }
        return Math.min(result, 24*60 - minutes[n-1] + minutes[0]);
    }

}
