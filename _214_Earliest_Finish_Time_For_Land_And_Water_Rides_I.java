public class _214_Earliest_Finish_Time_For_Land_And_Water_Rides_I {
    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {
                // Plan 1: Land ride first, then Water ride
                int landStart = landStartTime[i];
                int landEnd = landStart + landDuration[i];
                int waterStartAfterLand = Math.max(waterStartTime[j], landEnd);
                int waterEnd = waterStartAfterLand + waterDuration[j];
                minTime = Math.min(minTime, waterEnd);

                // Plan 2: Water ride first, then Land ride
                int waterStart = waterStartTime[j];
                int waterEnd2 = waterStart + waterDuration[j];
                int landStartAfterWater = Math.max(landStartTime[i], waterEnd2);
                int landEnd2 = landStartAfterWater + landDuration[i];
                minTime = Math.min(minTime, landEnd2);
            }
        }

        return minTime;
    }

    public static void main(String[] args) {
        System.out.println(earliestFinishTime(new int[]{2,8},new int[]{4,1},new int[]{6},new int[]{3}));
    }
}
