public class _91_AngleBetweenHandsOfAClock {
    public static void main(String[] args) {
        int hours = 12;
        int minutes = 30;
        System.out.println(angleClock(hours,minutes));
    }
    public static double angleClock(int hours, int minutes){
        int totalMinutes = hours * 60 + minutes;

        double hoursAngle = totalMinutes * 0.5;

        double minutesAngle = minutes * 6;

        if (hours >= 360) hoursAngle = hoursAngle - 360;

        double ans = Math.abs(minutesAngle - hoursAngle);

        if (ans > 180.00) ans = 360.00 - ans;

        return ans;
    }
}
