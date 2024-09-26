import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _172_MyCalendarI {
    public static void main(String[] args) {
        MyCalendar obj = new MyCalendar();
        boolean param_1 = obj.book(0,0);
        boolean param_2 = obj.book(10,20);
        boolean param_3 = obj.book(15,25);
        boolean param_4 = obj.book(20,30);
        System.out.println(param_1+" "+param_2+" "+param_3+" "+param_4);
    }
}
class MyCalendar {
    private List<int[]> events;
    public MyCalendar() {
        events = new ArrayList<>();
    }
    public boolean book(int start, int end) {
        for (int[] event : events) {
            if (start < event[1] && end > event[0]) {
                return false;
            }
        }
        events.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
