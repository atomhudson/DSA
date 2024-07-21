import java.util.Arrays;

public class _025_longestcommonprefix {
    public static String longestcommonprefix(String[] arr){
        if (arr == null || arr.length == 0) {
            return "";
        }
//        o ms
//        String lon = arr[0];
//        for (int j = 1; j < arr.length; j++) {
//            while (arr[j].indexOf(lon) != 0) {
//                lon = lon.substring(0, lon.length() - 1);
//                if (lon.isEmpty()) {
//                    return "";
//                }
//            }
//        }
//        return lon;
        Arrays.sort(arr);
        String lon = "";
        char[] first = arr[0].toCharArray();
        char[] last = arr[arr.length - 1].toCharArray();
        for (int i = 0; i < first.length && i < last.length; i++){
            if(first[i] == last[i]){
                lon += first[i];
            } else {
                break;
            }
        }
        return lon;

    }

    public static void main(String[] args) {
        String[] arr = {"club","clap","clove"};
        System.out.println(longestcommonprefix(arr));
    }
}
