package Algorithm_and_Practice;

import java.util.ArrayList;
import java.util.List;

class PeakCount{
    public int solution(int[] A) {
        int N = A.length;
        if (N < 3) return 0;

        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < N - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }

        int peakCount = peaks.size();
        if (peakCount == 0) return 0;


        int left = 1, right = peakCount;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canPlaceFlags(peaks, mid, N)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private boolean canPlaceFlags(List<Integer> peaks, int K, int N) {
        int flagsPlaced = 1;
        int lastFlagPosition = peaks.get(0);

        for (int i = 1; i < peaks.size(); i++) {
            if (peaks.get(i) - lastFlagPosition >= K) {
                flagsPlaced++;
                lastFlagPosition = peaks.get(i);
                if (flagsPlaced == K) return true;
            }
        }
        return false;
    }
}
public class _206_PeakCount {
    public static void main(String[] args) {
        PeakCount sol = new PeakCount();
        int[] arr = {1,5,3,4,3,4,1,2,3,4,6,2};
        System.out.println(sol.solution(arr));
    }
}
